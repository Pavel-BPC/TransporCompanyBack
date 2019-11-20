package com.blinets.services.imp;

import com.blinets.dto.TransportDto;
import com.blinets.entity.Transport;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import com.blinets.mapper.TransportMapper;
import com.blinets.repository.TransportRepository;
import com.blinets.services.CrudService;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransportService implements CrudService<TransportDto> {

  @Autowired
  private TransportRepository transportRepository;

  private TransportMapper mapper = Mappers.getMapper(TransportMapper.class);


  @Override
  public String create(TransportDto transportDto)
      throws DontExistsObjectInDatabaseException, UniqueObjectException {
    return transportRepository.save(mapper.transportDtoToTransport(transportDto)).getIdTransport();
  }

  @Override
  public List<TransportDto> get() {
    return mapper.convertListTransportToDto(transportRepository.findAll());
  }

  @Override
  public TransportDto get(String id) {
    return mapper.transportToDto(transportRepository.findByIdTransport(id));
  }

  @Override
  public void remove(String id) {
    transportRepository.deleteById(id);
  }

  @Override
  public void update(TransportDto object) throws DontExistsObjectInDatabaseException {
    throw new DontExistsObjectInDatabaseException();
  }
}
