package com.blinets.services.imp;

import com.blinets.dto.GeneralMapsDto;
import com.blinets.dto.MapsDto;
import com.blinets.dto.PointDto;
import com.blinets.dto.ProductDto;
import com.blinets.dto.RouteDto;
import com.blinets.dto.UserOrderProductDto;
import com.blinets.entity.Maps;
import com.blinets.entity.Point;
import com.blinets.entity.Product;
import com.blinets.entity.Route;
import com.blinets.entity.UserOrder;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import com.blinets.mapper.PointMapper;
import com.blinets.repository.MapsRepository;
import com.blinets.repository.PointRepository;
import com.blinets.repository.ProductRepository;
import com.blinets.repository.RouteRepository;
import com.blinets.repository.TransportRepository;
import com.blinets.repository.UserOrderRepository;
import com.blinets.services.CrudService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapsService implements CrudService<MapsDto> {

  private final PointServer pointServer;

  private final PointRepository pointRepository;
  private final TransportRepository transportRepository;
  private final RouteRepository routeRepository;
  private final MapsRepository mapsRepository;
  private final UserOrderProductService userOrderProductService;
  private PointMapper pointMapper = Mappers.getMapper(PointMapper.class);
  @Autowired
  private ProductRepository productRepository;
  @Autowired
  private UserOrderRepository userOrderRepository;

  @Autowired
  public MapsService(PointServer pointServer, PointRepository pointRepository,
      TransportRepository transportRepository, RouteRepository routeRepository,
      MapsRepository mapsRepository, UserOrderProductService userOrderProductService) {
    this.pointServer = pointServer;
    this.pointRepository = pointRepository;
    this.transportRepository = transportRepository;
    this.routeRepository = routeRepository;
    this.mapsRepository = mapsRepository;
    this.userOrderProductService = userOrderProductService;
  }

  @Override
  public String create(MapsDto mapsDto)
      throws DontExistsObjectInDatabaseException, UniqueObjectException {
    Maps maps = new Maps();

    maps.setIdMaps(UUID.randomUUID().toString());

    List<RouteDto> routeDtoList = mapsDto.getRouteDtos();
//    if (routeDtoList.size() % 2 != 0) {
//      throw new WrongNumberPointsInCards();
//    }

    RouteDto routeDtoFirst = routeDtoList.get(0);
    RouteDto routeDtoLast = routeDtoList.get(routeDtoList.size() - 1);

    Point byIdPointStart = pointRepository.findByIdPoint(routeDtoFirst.getPointDtoStart());
    Point byIdPointSecond = pointRepository.findByIdPoint(routeDtoFirst.getPointDtoEnd());
    Point byIdPointLast = pointRepository.findByIdPoint(routeDtoLast.getPointDtoEnd());

    maps.setStartIdPointOfRoute(byIdPointStart);
    maps.setEndIdPointOfRoute(byIdPointLast);

    Route routeMedium = new Route();
    Route routeFirst = new Route();
    routeFirst.setIdRoute(UUID.randomUUID().toString());
    routeFirst.setStartIdPointOfRoute(byIdPointStart);
    routeFirst.setEndIdPointOfRoute(byIdPointSecond);
    routeFirst
        .setIdTransport(transportRepository.findByIdTransport(routeDtoFirst.getIdTransport()));

    routeFirst.setCost(routeDtoFirst.getCost());
    routeFirst.setTime(routeDtoFirst.getTime());
    routeFirst.setDistance(routeDtoFirst.getDistance());

    routeFirst.setNextIdRoute(null);
    maps.setIdNextRoute(new Route(routeFirst));
    for (int i = 1; i < routeDtoList.size(); i++) {
      RouteDto routeDto = routeDtoList.get(i);

      routeMedium.setIdRoute(UUID.randomUUID().toString());
      routeMedium
          .setStartIdPointOfRoute(pointRepository.findByIdPoint(routeDto.getPointDtoStart()));
      routeMedium.setEndIdPointOfRoute(pointRepository.findByIdPoint(routeDto.getPointDtoEnd()));
      routeMedium.setIdTransport(transportRepository.findByIdTransport(routeDto.getIdTransport()));

      routeMedium.setCost(routeDto.getCost());
      routeMedium.setTime(routeDto.getTime());
      routeMedium.setDistance(routeDto.getDistance());

      routeMedium.setNextIdRoute(null);

      routeFirst.setNextIdRoute(routeMedium.getIdRoute());

      routeRepository.save(routeFirst);
      routeFirst = new Route(routeMedium);

    }
    routeRepository.save(routeFirst);

    mapsRepository.save(maps);
    return maps.getIdMaps();
  }

  @Override
  public List<MapsDto> get() {
    return null;
  }

  @Override
  public MapsDto get(String id) {
    return null;
  }

  public GeneralMapsDto getGeneralMapsDtoWithPoints(String id) {
    Maps maps = mapsRepository.findByIdMaps(id);

    return getGeneralMapDtoByIdMap(maps);

  }

  public GeneralMapsDto getGeneralMapDtoByIdMap(Maps maps) {
    Route route = routeRepository.findByIdRoute(maps.getIdNextRoute().getIdRoute());
    GeneralMapsDto generalMapsDto = new GeneralMapsDto();
    generalMapsDto.setIdMap(maps.getIdMaps());
    generalMapsDto.setNameStartPoint(maps.getStartIdPointOfRoute().getNamePoint());

    generalMapsDto.setPointList(new ArrayList<PointDto>());

    Integer generalDistance = 0;
    Integer generalCost = 0;
    Integer generalTime = 0;

    while (true) {
      generalDistance += route.getDistance();
      generalCost += route.getCost();
      generalTime += route.getTime();
      generalMapsDto.getPointList()
          .add(pointMapper.pointToPointDto(route.getStartIdPointOfRoute()));
      if (route.getNextIdRoute() == null) {
        generalMapsDto.getPointList()
            .add(pointMapper.pointToPointDto(route.getEndIdPointOfRoute()));
        generalMapsDto.setNameEndPoint(route.getEndIdPointOfRoute().getNamePoint());
        break;
      }

      route = routeRepository.findByIdRoute(route.getNextIdRoute());
    }
    generalMapsDto.setGeneralDistance(String.valueOf(generalDistance));
    generalMapsDto.setGeneralCost(String.valueOf(generalCost));
    generalMapsDto.setGeneralTime(String.valueOf(generalTime));
    return generalMapsDto;
  }

  public List<GeneralMapsDto> getGeneralListMapsDtoWithPoints() {
    return mapsRepository.findAll().stream().map(this::getGeneralMapDtoByIdMap)
        .collect(Collectors.toList());
  }

  public List<GeneralMapsDto> getGeneralMapDtoByIdMap() {
    List<Maps> mapsList = mapsRepository.findAll();
    List<GeneralMapsDto> generalMapsDtoList = new ArrayList<>();
    for (Maps maps : mapsList) {

      Route byIdRoute = routeRepository.findByIdRoute(maps.getIdNextRoute().getIdRoute());

      GeneralMapsDto generalMapsDto = new GeneralMapsDto();
      generalMapsDto.setIdMap(maps.getIdMaps());
      generalMapsDto.setNameStartPoint(maps.getStartIdPointOfRoute().getNamePoint());
      generalMapsDto.setPointList(null);
      Integer generalDistance = 0;
      Integer generalCost = 0;
      Integer generalTime = 0;

      while (true) {
        generalDistance += byIdRoute.getDistance();
        generalCost += byIdRoute.getCost();
        generalTime += byIdRoute.getTime();
        if (byIdRoute.getNextIdRoute() == null) {
          generalMapsDto.setNameEndPoint(byIdRoute.getEndIdPointOfRoute().getNamePoint());
          break;
        }
        byIdRoute = routeRepository.findByIdRoute(byIdRoute.getNextIdRoute());
      }
      generalMapsDto.setGeneralDistance(String.valueOf(generalDistance));
      generalMapsDto.setGeneralCost(String.valueOf(generalCost));
      generalMapsDto.setGeneralTime(String.valueOf(generalTime));

      generalMapsDtoList.add(generalMapsDto);
    }

    return generalMapsDtoList;
  }

  public void saveUserOrderProduct(String id) {

    List<ProductDto> optimalProduct = userOrderProductService.getOptimalProduct(id);
    GeneralMapsDto generalMapsDtoByIdMap = getGeneralMapDtoByIdMap(
        mapsRepository.findByIdMaps(id));
    for (ProductDto productDto : optimalProduct
    ) {
      Product product = productRepository.findByIdProduct(productDto.getId());
      UserOrder userOrder = product.getUserOrder();

      if (product.getTypeProduct().equals("1")) {
        userOrder.setPrice((
            product.getWeightProduct() * 75 * Integer
                .parseInt(generalMapsDtoByIdMap.getGeneralDistance())) +
            Integer.parseInt(generalMapsDtoByIdMap.getGeneralCost()));
      } else {
        userOrder.setPrice((product.getWeightProduct() * 50 * Integer
            .parseInt(generalMapsDtoByIdMap.getGeneralDistance())) +
            Integer.parseInt(generalMapsDtoByIdMap.getGeneralCost()));
      }
      userOrder.setStatus("In progress");
      userOrderRepository.save(userOrder);
    }

  }


  @Override
  public void remove(String id) {
    mapsRepository.deleteById(id);
  }

  @Override
  public void update(MapsDto object) throws DontExistsObjectInDatabaseException {

  }

  @PostConstruct
  void init() throws IOException, UniqueObjectException, DontExistsObjectInDatabaseException {
    MapsDto mapsDto = new ObjectMapper().readValue(
        "{\"routeDtos\":[{\"start_point\":\"459c7b45-bddc-48af-affd-30f4268aa946\",\"end_point\":\"cbd29f42-a5cc-4e9c-a906-8b2e842244db\",\"transport\":\"a3ba172f-d772-487e-a820-5e4595e96be5\",\"distance\":\"100\",\"cost\":\"100\",\"time\":\"20\"},{\"start_point\":\"cbd29f42-a5cc-4e9c-a906-8b2e842244db\",\"end_point\":\"5db17bc6-1bd7-4a0b-b043-604ca718e06f\",\"transport\":\"16995a17-a0fc-46e0-a602-dc54b7dc462c\",\"distance\":\"100\",\"cost\":\"200\",\"time\":\"20\"},{\"start_point\":\"5db17bc6-1bd7-4a0b-b043-604ca718e06f\",\"end_point\":\"8211e92f-ba50-41f1-b99c-c961353d90bf\",\"transport\":\"4dbae581-4aae-4018-af66-0520525542d4\",\"distance\":\"200\",\"cost\":\"40\",\"time\":\"30\"}]}"
        , MapsDto.class);
    String idMap1 = create(mapsDto);
    mapsDto = new ObjectMapper().readValue(
        "{\"routeDtos\":[{\"start_point\":\"459c7b45-bddc-48af-affd-30f4268aa946\",\"end_point\":\"cbd29f42-a5cc-4e9c-a906-8b2e842244db\",\"transport\":\"a3ba172f-d772-487e-a820-5e4595e96be5\",\"distance\":\"100\",\"cost\":\"100\",\"time\":\"20\"},{\"start_point\":\"cbd29f42-a5cc-4e9c-a906-8b2e842244db\",\"end_point\":\"5db17bc6-1bd7-4a0b-b043-604ca718e06f\",\"transport\":\"16995a17-a0fc-46e0-a602-dc54b7dc462c\",\"distance\":\"100\",\"cost\":\"200\",\"time\":\"20\"},{\"start_point\":\"5db17bc6-1bd7-4a0b-b043-604ca718e06f\",\"end_point\":\"8211e92f-ba50-41f1-b99c-c961353d90bf\",\"transport\":\"4dbae581-4aae-4018-af66-0520525542d4\",\"distance\":\"200\",\"cost\":\"40\",\"time\":\"30\"},{\"start_point\":\"8211e92f-ba50-41f1-b99c-c961353d90bf\",\"end_point\":\"dad7d429-8f2d-4e22-af40-a3cb929cbddc\",\"transport\":\"4dbae581-4aae-4018-af66-0520525542d4\",\"distance\":\"321\",\"cost\":\"17\",\"time\":\"50\"}]}"
        , MapsDto.class);
    String idMap2 = create(mapsDto);
    mapsDto = new ObjectMapper().readValue(
        "{\"routeDtos\":[{\"start_point\":\"459c7b45-bddc-48af-affd-30f4268aa946\",\"end_point\":\"cbd29f42-a5cc-4e9c-a906-8b2e842244db\",\"transport\":\"a3ba172f-d772-487e-a820-5e4595e96be5\",\"distance\":\"100\",\"cost\":\"100\",\"time\":\"20\"},{\"start_point\":\"cbd29f42-a5cc-4e9c-a906-8b2e842244db\",\"end_point\":\"5db17bc6-1bd7-4a0b-b043-604ca718e06f\",\"transport\":\"16995a17-a0fc-46e0-a602-dc54b7dc462c\",\"distance\":\"100\",\"cost\":\"200\",\"time\":\"20\"},{\"start_point\":\"5db17bc6-1bd7-4a0b-b043-604ca718e06f\",\"end_point\":\"8211e92f-ba50-41f1-b99c-c961353d90bf\",\"transport\":\"4dbae581-4aae-4018-af66-0520525542d4\",\"distance\":\"200\",\"cost\":\"40\",\"time\":\"30\"},{\"start_point\":\"8211e92f-ba50-41f1-b99c-c961353d90bf\",\"end_point\":\"dad7d429-8f2d-4e22-af40-a3cb929cbddc\",\"transport\":\"4dbae581-4aae-4018-af66-0520525542d4\",\"distance\":\"321\",\"cost\":\"17\",\"time\":\"50\"},{\"start_point\":\"dad7d429-8f2d-4e22-af40-a3cb929cbddc\",\"end_point\":\"45b09dec-323e-4e70-b7f9-ce877efb1616\",\"transport\":\"4dbae581-4aae-4018-af66-0520525542d4\",\"distance\":\"54\",\"cost\":\"34\",\"time\":\"65\"}]}"
        , MapsDto.class);
    String idMap3 = create(mapsDto);

    UserOrderProductDto userOrderProductDto =
        new ObjectMapper().readValue(
            "{\"start_point\":\"459c7b45-bddc-48af-affd-30f4268aa946\",\"end_point\":\"8211e92f-ba50-41f1-b99c-c961353d90bf\",\"weight_product\":\"100\",\"type_product\":\"1\",\"name_product\":\"Торф\",\"id_user\":\"cbd29f42-a5cc-4e9c-a906-8b2e842244db\"}"
            , UserOrderProductDto.class);
    String idUserOrder1 = userOrderProductService.createUserOrderProduct(userOrderProductDto);

    userOrderProductDto =
        new ObjectMapper().readValue(
            "{\"start_point\":\"459c7b45-bddc-48af-affd-30f4268aa946\",\"end_point\":\"8211e92f-ba50-41f1-b99c-c961353d90bf\",\"weight_product\":\"100\",\"type_product\":\"1\",\"name_product\":\"Уголь\",\"id_user\":\"cbd29f42-a5cc-4e9c-a906-8b2e842244db\"}"
            , UserOrderProductDto.class);
    String idUserOrder2 = userOrderProductService.createUserOrderProduct(userOrderProductDto);

    userOrderProductDto =
        new ObjectMapper().readValue(
            "{\"start_point\":\"459c7b45-bddc-48af-affd-30f4268aa946\",\"end_point\":\"8211e92f-ba50-41f1-b99c-c961353d90bf\",\"weight_product\":\"50\",\"type_product\":\"2\",\"name_product\":\"Стаканчики\",\"id_user\":\"cbd29f42-a5cc-4e9c-a906-8b2e842244db\"}"
            , UserOrderProductDto.class);
    String idUserOrder3 = userOrderProductService.createUserOrderProduct(userOrderProductDto);

    userOrderProductDto =
        new ObjectMapper().readValue(
            "{\"start_point\":\"459c7b45-bddc-48af-affd-30f4268aa946\",\"end_point\":\"8211e92f-ba50-41f1-b99c-c961353d90bf\",\"weight_product\":\"75\",\"type_product\":\"2\",\"name_product\":\"Столы\",\"id_user\":\"cbd29f42-a5cc-4e9c-a906-8b2e842244db\"}"
            , UserOrderProductDto.class);
    String idUserOrder4 = userOrderProductService.createUserOrderProduct(userOrderProductDto);

    userOrderProductDto =
        new ObjectMapper().readValue(
            "{\"start_point\":\"459c7b45-bddc-48af-affd-30f4268aa946\",\"end_point\":\"dad7d429-8f2d-4e22-af40-a3cb929cbddc\",\"weight_product\":\"75\",\"type_product\":\"2\",\"name_product\":\"Столы\",\"id_user\":\"cbd29f42-a5cc-4e9c-a906-8b2e842244db\"}"
            , UserOrderProductDto.class);
    String idUserOrder5 = userOrderProductService.createUserOrderProduct(userOrderProductDto);

    userOrderProductDto =
        new ObjectMapper().readValue(
            "{\"start_point\":\"459c7b45-bddc-48af-affd-30f4268aa946\",\"end_point\":\"45b09dec-323e-4e70-b7f9-ce877efb1616\",\"weight_product\":\"20\",\"type_product\":\"1\",\"name_product\":\"Тумбы\",\"id_user\":\"cbd29f42-a5cc-4e9c-a906-8b2e842244db\"}"
            , UserOrderProductDto.class);
    String idUserOrder6 = userOrderProductService.createUserOrderProduct(userOrderProductDto);

  }
}
