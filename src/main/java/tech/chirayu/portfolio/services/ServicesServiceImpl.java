package tech.chirayu.portfolio.services;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.chirayu.portfolio.dto.ServiceDto;
import tech.chirayu.portfolio.entity.ServiceEntity;
import tech.chirayu.portfolio.repositories.ContactRepository;
import tech.chirayu.portfolio.repositories.ServiceRepository;

@Service
public class ServicesServiceImpl implements ServicesService{
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ServiceEntity saveservice(ServiceDto serviceDto, String filename) {
		
		ServiceEntity serviceEntity = modelMapper.map(serviceDto, ServiceEntity.class);
		serviceEntity.setFilename(filename);
		serviceEntity.setDate(LocalDateTime.now().toString());
		
		return serviceRepository.save(serviceEntity);
	}
	

}
