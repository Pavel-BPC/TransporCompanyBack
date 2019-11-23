package com.blinets.mapper;

import com.blinets.dto.CompanyDto;
import com.blinets.entity.Company;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface CompanyMapper {

  Company companyDtoToCompany(CompanyDto companyDto);

  CompanyDto companyToCompanyDto(Company company);

  List<Company> listCompanyDtoToCompanyList(List<CompanyDto> companyDtos);

  List<CompanyDto> listCompanyToCompanyDtoList(List<Company> companies);


}