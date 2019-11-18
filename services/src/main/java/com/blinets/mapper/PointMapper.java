package com.blinets.mapper;

import com.blinets.dto.PointDto;
import com.blinets.entity.Point;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface PointMapper {

  Point pointDtoToPoint(PointDto pointDto);

  PointDto pointToPointDto(Point point);

  List<Point> listPointDtoToPointList(List<PointDto> pointDtos);

  List<PointDto> listPointToPointDtoList(List<Point> point);


}
