package com.blinets.services.imp;

import com.blinets.dto.MapsDto;
import com.blinets.dto.RouteDto;
import com.blinets.entity.Maps;
import com.blinets.entity.Point;
import com.blinets.entity.Route;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import com.blinets.exceptions.WrongNumberPointsInCards;
import com.blinets.repository.MapsRepository;
import com.blinets.repository.PointRepository;
import com.blinets.repository.RouteRepository;
import com.blinets.repository.TransportRepository;
import com.blinets.services.CrudService;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapsService implements CrudService<MapsDto> {

  @Autowired
  private PointServer pointServer;

  @Autowired
  private PointRepository pointRepository;
  @Autowired
  private TransportRepository transportRepository;
  @Autowired
  private RouteRepository routeRepository;
  @Autowired
  private MapsRepository mapsRepository;

  @Override
  public String create(MapsDto mapsDto)
      throws DontExistsObjectInDatabaseException, UniqueObjectException {
    Maps maps = new Maps();

    maps.setIdMaps(UUID.randomUUID().toString());

    List<RouteDto> routeDtoList = mapsDto.getRouteDtos();
    if (routeDtoList.size() % 2 != 0) {
      throw new WrongNumberPointsInCards();
    }

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

    for (int i = 1; i <= routeDtoList.size() - 1; i++) {
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
      routeFirst = routeMedium;

    }
    routeRepository.save(routeMedium);

    maps.setIdRoute(routeFirst);
    mapsRepository.save(maps);
    return null;
  }

  @Override
  public List<MapsDto> get() {
    return null;
  }

  @Override
  public MapsDto get(String id) {
    return null;
  }

  @Override
  public void remove(String id) {
    mapsRepository.deleteById(id);
  }

  @Override
  public void update(MapsDto object) throws DontExistsObjectInDatabaseException {

  }
}
