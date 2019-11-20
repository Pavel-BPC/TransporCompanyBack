package com.blinets.mapper;

import com.blinets.dto.TransportDto;
import com.blinets.entity.Transport;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface TransportMapper {

  @Mappings({@Mapping(target = "idCompany", source = "transport.company.idCompany")})
  TransportDto transportToDto(Transport transport);

  @Mappings({@Mapping(target = "company.idCompany", source = "transportDto.idCompany")})
  Transport transportDtoToTransport(TransportDto transportDto);

  List<TransportDto> convertListTransportToDto(List<Transport> transports);

  List<Transport> convertListDtoToTransport(List<TransportDto> transportDtos);

}


