package tech.chirayu.portfolio.services;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tech.chirayu.portfolio.dto.ServiceDto;
import tech.chirayu.portfolio.entity.ServiceEntity;

@Service
public interface ServicesService {
	
	

	ServiceEntity saveservice(String realPath, MultipartFile multipart, ServiceDto serviceDto) throws IllegalStateException, IOException;
	
	List<ServiceEntity> readServices();
}