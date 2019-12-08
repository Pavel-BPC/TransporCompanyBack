package com.blinets.services.imp;

import com.blinets.dto.TransportDto;
import com.blinets.entity.Transport;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import com.blinets.mapper.TransportMapper;
import com.blinets.repository.CompanyRepository;
import com.blinets.repository.TransportRepository;
import com.blinets.services.CrudService;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransportService implements CrudService<TransportDto> {

  @Autowired
  private TransportRepository transportRepository;
  @Autowired
  private CompanyRepository companyRepository;

  private TransportMapper mapper = Mappers.getMapper(TransportMapper.class);


  @Override
  public String create(TransportDto transportDto)
      throws DontExistsObjectInDatabaseException, UniqueObjectException {
    Transport transport = mapper.transportDtoToTransport(transportDto);
    transport.setIdTransport(UUID.randomUUID().toString());
//    transport.setCompany(companyRepository.findByIdCompany(transportDto.getIdCompany()));
    return transportRepository.save(transport).getIdTransport();
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
    transportRepository.deleteByIdTransport(id);
  }

  @Override
  public void update(TransportDto transportDto) throws DontExistsObjectInDatabaseException {
    Transport transport = transportRepository.findByIdTransport(transportDto.getIdTransport());
    if (StringUtils.isNotEmpty(transportDto.getNameTransport())) {
      transport.setNameTransport(transportDto.getNameTransport());
    }
    transport.setMaxWeight(transportDto.getMaxWeight());
    transport.setSpeed(transportDto.getSpeed());
    transport.setTariffPlan(transportDto.getTariffPlan());


  }

  @PostConstruct
  public void init() {
//    Company company1 = new Company();
//    Company company2 = new Company();
//    company1.setIdCompany("de871baf-b12a-4bcb-9915-b303d7f41813");
//    company2.setIdCompany("696ea116-8305-4e65-899b-07d27b49cfb2");
//    transportRepository.saveAll(
//        Arrays.asList(
//            new Transport("a3ba172f-d772-487e-a820-5e4595e96be5","Трактор",1,300,45,company1),
//            new Transport("16995a17-a0fc-46e0-a602-dc54b7dc462c","Маз",3,150,76,company1),
//            new Transport("4dbae581-4aae-4018-af66-0520525542d4","Белаз",2,250,36,company2),
//            new Transport("0cbce512-9cd3-4cf1-b32a-8cdda4c93065","Камаз",4,400,90,company2)
//        )
//
//    );
  }
}
