package com.blinets.services.imp;

import com.blinets.dto.CompanyDto;
import com.blinets.entity.Company;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import com.blinets.mapper.CompanyMapper;
import com.blinets.repository.CompanyRepository;
import com.blinets.services.CrudService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService implements CrudService<CompanyDto> {

  @Autowired
  private CompanyRepository companyRepository;


  private CompanyMapper companyMapper = Mappers.getMapper(CompanyMapper.class);


  @Override
  public String create(CompanyDto companyDto)
      throws DontExistsObjectInDatabaseException, UniqueObjectException {
    return companyRepository.save(companyMapper.companyDtoToCompany(companyDto)).getIdCompany();
  }

  @Override
  public List<CompanyDto> get() {

    return companyMapper.listCompanyToCompanyDtoList(companyRepository.findAll());
  }

  @Override
  public CompanyDto get(String id) {
    return companyMapper.companyToCompanyDto(companyRepository.findByIdCompany(id));
  }

  @Override
  public void remove(String id) {
    companyRepository.deleteById(id);
  }

  @Override
  public void update(CompanyDto companyDto) throws DontExistsObjectInDatabaseException {
    Company company = companyRepository.findByIdCompany(companyDto.getIdCompany());

    if (StringUtils.isNotEmpty(companyDto.getNameCompany())) {
      company.setNameCompany(companyDto.getNameCompany());
    }
    if (StringUtils.isNotEmpty(companyDto.getDescription())) {
      company.setDescription(companyDto.getDescription());
    }
    if (StringUtils.isNotEmpty(companyDto.getEmailCompany())) {
      company.setEmailCompany(companyDto.getEmailCompany());
    }
    if (StringUtils.isNotEmpty(companyDto.getPhoneCompany())) {
      company.setPhoneCompany(companyDto.getPhoneCompany());
    }

  }
}
