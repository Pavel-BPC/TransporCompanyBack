package com.blinets.services.imp;

import com.blinets.dto.PointDto;
import com.blinets.entity.Point;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import com.blinets.mapper.PointMapper;
import com.blinets.mapper.UserMapper;
import com.blinets.repository.PointRepository;
import com.blinets.services.CrudService;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
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
    pointRepository.removeByIdPoint(id);
  }

  @Override
  public void update(PointDto pointDto) throws DontExistsObjectInDatabaseException {
    Point point = pointMapper.pointDtoToPoint(pointDto);
    Point byIdPoint = pointRepository.findByIdPoint(point.getIdPoint());
    byIdPoint.setNamePoint(point.getNamePoint());
    pointRepository.save(byIdPoint);
  }

  @PostConstruct
  public void init(){
//    pointRepository.saveAll(Arrays.asList(
//        new Point("459c7b45-bddc-48af-affd-30f4268aa946","Клецк"),
//        new Point("cbd29f42-a5cc-4e9c-a906-8b2e842244db","Солигорск"),
//        new Point("5db17bc6-1bd7-4a0b-b043-604ca718e06f","Минск"),
//        new Point("8211e92f-ba50-41f1-b99c-c961353d90bf","Гродно"),
//        new Point("dad7d429-8f2d-4e22-af40-a3cb929cbddc","Орша"),
//        new Point("45b09dec-323e-4e70-b7f9-ce877efb1616","Речица")
//            ));
  }
}
