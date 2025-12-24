package tech.chirayu.portfolio.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tech.chirayu.portfolio.dto.ServiceDto;
import tech.chirayu.portfolio.entity.ServiceEntity;

@Service
public interface ServicesService {
	
	

	ServiceEntity saveservice(String realPath, MultipartFile multipart, ServiceDto serviceDto) throws IllegalStateException, IOException;
	
	List<ServiceEntity> readServices();
	
	void deleteServicedata(String realPath,int id,String filename);
	
	Optional<ServiceEntity> readService(int id);
	
	ServiceEntity updateService(String realPath, MultipartFile multipart, ServiceDto serviceDto, int id,String oldfilename) throws IllegalStateException, IOException,Exception;
	
}