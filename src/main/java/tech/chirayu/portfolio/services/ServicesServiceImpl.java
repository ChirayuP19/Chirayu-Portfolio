package tech.chirayu.portfolio.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	@Transactional(rollbackOn = Exception.class)
	public ServiceEntity saveservice(String realPath, MultipartFile multipart, ServiceDto serviceDto) throws IllegalStateException, IOException {
		
		// this is the database logic
		String Filename=UUID.randomUUID().toString()+LocalDateTime.now().toString().replace(":", "!")+multipart.getOriginalFilename();
		ServiceEntity serviceEntity = modelMapper.map(serviceDto, ServiceEntity.class);
		serviceEntity.setFilename(Filename);
		serviceEntity.setDate(LocalDateTime.now().toString());
		 
		ServiceEntity entity = serviceRepository.save(serviceEntity);
		
		// file making and logic checking. 
		Path path = Paths.get(realPath, Filename);
		File file = path.toFile();
		multipart.transferTo(file);
	
		
		
		return entity;
	}

	@Override
	public List<ServiceEntity> readServices() {
		return serviceRepository.findAll();
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void deleteServicedata(String realPath, int id, String filename) {
	serviceRepository.deleteById(id);
	File file = new File(realPath+File.separator+filename);
	file.delete();
	}

	@Override
	public Optional<ServiceEntity> readService(int id) {
		
		return serviceRepository.findById(id);
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public ServiceEntity updateService(String realPath, MultipartFile multipart, ServiceDto serviceDto, int id,
			String oldfilename) throws IllegalStateException, IOException, Exception {
	
		if(multipart!=null && !multipart.isEmpty()) {
			//new file send.
			String Filename=UUID.randomUUID().toString()+LocalDateTime.now().toString().replace(":", "!")+multipart.getOriginalFilename();
			
			ServiceEntity serviceEntity = modelMapper.map(serviceDto, ServiceEntity.class);
			serviceEntity.setId(id);
			serviceEntity.setFilename(Filename);
			serviceEntity.setDate(LocalDateTime.now().toString());
			ServiceEntity entity = serviceRepository.save(serviceEntity);
			
			new File(realPath+File.separator+oldfilename).delete();
			
			Path path = Paths.get(realPath, Filename);
			File file= path.toFile();
			multipart.transferTo(file);
			
			return entity;
		
		}else {
			// old file but data is new. 
			ServiceEntity serviceEntity = modelMapper.map(serviceDto, ServiceEntity.class);
			serviceEntity.setId(id);
			serviceEntity.setFilename(oldfilename);
			serviceEntity.setDate(LocalDateTime.now().toString());
			ServiceEntity entity = serviceRepository.save(serviceEntity);
			return entity;
		}
		
		
	}
	

}
