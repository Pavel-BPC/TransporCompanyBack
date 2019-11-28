package com.blinets.services.imp;

import com.blinets.dto.GeneralMapsDto;
import com.blinets.dto.MapsDto;
import com.blinets.dto.PointDto;
import com.blinets.dto.RouteDto;
import com.blinets.entity.Maps;
import com.blinets.entity.Point;
import com.blinets.entity.Route;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import com.blinets.mapper.PointMapper;
import com.blinets.repository.MapsRepository;
import com.blinets.repository.PointRepository;
import com.blinets.repository.RouteRepository;
import com.blinets.repository.TransportRepository;
import com.blinets.services.CrudService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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
  private PointMapper pointMapper = Mappers.getMapper(PointMapper.class);


  @Autowired
  public MapsService(PointServer pointServer, PointRepository pointRepository,
      TransportRepository transportRepository, RouteRepository routeRepository,
      MapsRepository mapsRepository) {
    this.pointServer = pointServer;
    this.pointRepository = pointRepository;
    this.transportRepository = transportRepository;
    this.routeRepository = routeRepository;
    this.mapsRepository = mapsRepository;
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
    routeFirst.setTime(LocalDate.parse(routeDtoFirst.getTime()));
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
      routeMedium.setTime(LocalDate.parse(routeDto.getTime()));
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
    Maps byIdMaps = mapsRepository.findByIdMaps(id);
    Route byIdRoute = routeRepository.findByIdRoute(byIdMaps.getIdNextRoute().getIdRoute());

    GeneralMapsDto generalMapsDto = new GeneralMapsDto();
    generalMapsDto.setIdMap(id);
    generalMapsDto.setName_start_point(byIdMaps.getStartIdPointOfRoute().getNamePoint());

    generalMapsDto.setPointList(new ArrayList<PointDto>());

    Integer generalDistance =0 ;
    Integer generalCost = 0;

    while (true) {
      generalDistance += byIdRoute.getDistance();
      generalCost += byIdRoute.getCost();
      generalMapsDto.getPointList()
          .add(pointMapper.pointToPointDto(byIdRoute.getStartIdPointOfRoute()));
      if (byIdRoute.getNextIdRoute() == null) {
        generalMapsDto.getPointList()
            .add(pointMapper.pointToPointDto(byIdRoute.getEndIdPointOfRoute()));
        generalMapsDto.setName_end_point(byIdRoute.getEndIdPointOfRoute().getNamePoint());
        break;
      }

      byIdRoute = routeRepository.findByIdRoute(byIdRoute.getNextIdRoute());
    }
    generalMapsDto.setGeneral_distance(String.valueOf(generalDistance));
    generalMapsDto.setGeneral_cost(String.valueOf(generalCost));

    return generalMapsDto;
  }

  public List<GeneralMapsDto> getGeneralMapsDto() {
    List<Maps> mapsList = mapsRepository.findAll();
    List<GeneralMapsDto> generalMapsDtoList = new ArrayList<>();
    for (Maps maps:mapsList ) {

      Route byIdRoute = routeRepository.findByIdRoute(maps.getIdNextRoute().getIdRoute());

      GeneralMapsDto generalMapsDto = new GeneralMapsDto();
      generalMapsDto.setIdMap(maps.getIdMaps());
      generalMapsDto.setName_start_point(maps.getStartIdPointOfRoute().getNamePoint());
      generalMapsDto.setPointList(null);
      Integer generalDistance = 0;
      Integer generalCost = 0;

      while (true) {
        generalDistance += byIdRoute.getDistance();
        generalCost += byIdRoute.getCost();
        if (byIdRoute.getNextIdRoute() == null) {
          generalMapsDto.setName_end_point(byIdRoute.getEndIdPointOfRoute().getNamePoint());
          break;
        }
        byIdRoute = routeRepository.findByIdRoute(byIdRoute.getNextIdRoute());
      }
      generalMapsDto.setGeneral_distance(String.valueOf(generalDistance));
      generalMapsDto.setGeneral_cost(String.valueOf(generalCost));

      generalMapsDtoList.add(generalMapsDto);
    }

    return generalMapsDtoList;
  }

  @Override
  public void remove(String id) {
    mapsRepository.deleteById(id);
  }

  @Override
  public void update(MapsDto object) throws DontExistsObjectInDatabaseException {

  }

//  @PostConstruct
//  void init() throws IOException, UniqueObjectException, DontExistsObjectInDatabaseException {
//    MapsDto mapsDto = new ObjectMapper().readValue(
//        "{\n"
//            + "\"routeDtos\":  [\n"
//            + "  {\n"
//            + "  \"start_point\": \"45b09dec-323e-4e70-b7f9-ce877efb1616\",\n"
//            + "  \"end_point\": \"cbd29f42-a5cc-4e9c-a906-8b2e842244db\",\n"
//            + "  \"transport\": \"a3ba172f-d772-487e-a820-5e4595e96be5\",\n"
//            + "  \"distance\": \"999\",\n"
//            + "  \"cost\": \"999\",\n"
//            + "  \"time\": \"2019-11-28\"\n"
//            + "  },\n"
//            + "   {\n"
//            + "  \"start_point\": \"cbd29f42-a5cc-4e9c-a906-8b2e842244db\",\n"
//            + "  \"end_point\": \"5db17bc6-1bd7-4a0b-b043-604ca718e06f\",\n"
//            + "  \"transport\": \"a3ba172f-d772-487e-a820-5e4595e96be5\",\n"
//            + "  \"distance\": \"100\",\n"
//            + "  \"cost\": \"100\",\n"
//            + "  \"time\": \"2019-11-28\"\n"
//            + "  }\n"
//            + "] \n"
//            + "}"
//    ,MapsDto.class);
//
//    create(mapsDto);
//  }
}
