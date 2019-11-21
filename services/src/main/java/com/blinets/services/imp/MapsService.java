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
  private RouteRepository  routeRepository;
  @Autowired
  private MapsRepository mapsRepository;

  @Override
  public String create(MapsDto mapsDto)
      throws DontExistsObjectInDatabaseException, UniqueObjectException {
    Maps maps = new Maps();

    maps.setIdMaps(UUID.randomUUID().toString());
//    maps.setCost(mapsDto.getCost());
//    maps.setTime(mapsDto.getTime());
//    maps.setDistance(mapsDto.getDistance());

    List<RouteDto> routeDtos = mapsDto.getRouteDtos();
    if (routeDtos.size() % 2 != 0) {
      throw new WrongNumberPointsInCards();
    }

    RouteDto routeDtoFirst = routeDtos.get(0);
    RouteDto routeDtoLast = routeDtos.get(routeDtos.size() - 1);

    Point byIdPointStart = pointRepository.findByIdPoint(routeDtoFirst.getPointDtoStart());
    Point byIdPointSecond = pointRepository.findByIdPoint(routeDtoFirst.getPointDtoEnd());

    maps.setStartIdPointOfRoute(byIdPointStart);
    maps.setEndIdPointOfRoute(pointRepository.findByIdPoint(routeDtoLast.getPointDtoEnd()));



    Route routeMedium = new Route();
    Route routeFirst = new Route();
    routeFirst.setIdRoute(UUID.randomUUID().toString());
    routeFirst.setStartIdPointOfRoute(byIdPointStart);
    routeFirst.setEndIdPointOfRoute(byIdPointSecond);
    routeFirst.setIdTransport(transportRepository.findByIdTransport(routeDtoFirst.getIdTransport()));
    routeFirst.setIdRoute(null);

    for (int i = 1; i < routeDtos.size() - 1; i++) {
      RouteDto routeDto = routeDtos.get(i);

      routeMedium.setIdRoute(UUID.randomUUID().toString());
      routeMedium.setStartIdPointOfRoute(pointRepository.findByIdPoint(routeDto.getPointDtoStart()));
      routeMedium.setEndIdPointOfRoute(pointRepository.findByIdPoint(routeDto.getPointDtoEnd()));
      routeMedium.setIdTransport(transportRepository.findByIdTransport(routeDto.getIdTransport()));
      routeMedium.setIdRoute(null);

      routeFirst.setNextIdRoute(routeMedium.getIdRoute());

      routeRepository.save(routeFirst);
      routeFirst = routeMedium;

    }

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

  }

  @Override
  public void update(MapsDto object) throws DontExistsObjectInDatabaseException {

  }
}
