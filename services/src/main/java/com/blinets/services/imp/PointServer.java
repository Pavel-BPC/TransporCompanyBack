package com.blinets.services.imp;

import com.blinets.dto.PointDto;
import com.blinets.entity.Point;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import com.blinets.mapper.PointMapper;
import com.blinets.mapper.UserMapper;
import com.blinets.repository.PointRepository;
import com.blinets.services.CrudService;
import java.util.List;
import java.util.UUID;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointServer implements CrudService<PointDto> {

  @Autowired
  private PointRepository pointRepository;

  private PointMapper pointMapper  = Mappers.getMapper(PointMapper.class);

  @Override
  public String create(PointDto pointDto)
      throws DontExistsObjectInDatabaseException, UniqueObjectException {
    Point point = pointMapper.pointDtoToPoint(pointDto);
    point.setIdPoint(UUID.randomUUID().toString());
    pointRepository.save(point);
    return point.getIdPoint();
  }

  @Override
  public List<PointDto> get() {
    return pointMapper.listPointToPointDtoList(pointRepository.findAll());
  }

  @Override
  public PointDto get(String id) {
    return pointMapper.pointToPointDto(pointRepository.findByIdPoint(id));
  }

  @Override
  public void remove(String id) {
    pointRepository.deleteByIdPoint(id);
  }

  @Override
  public void update(PointDto pointDto) throws DontExistsObjectInDatabaseException {
    Point point = pointMapper.pointDtoToPoint(pointDto);
    Point byIdPoint = pointRepository.findByIdPoint(point.getIdPoint());
    byIdPoint.setNamePoint(point.getNamePoint());
    pointRepository.save(byIdPoint);
  }
}
