package tech.chirayu.portfolio.services;

import org.springframework.stereotype.Service;

import tech.chirayu.portfolio.dto.ServiceDto;
import tech.chirayu.portfolio.entity.ServiceEntity;

@Service
public interface ServicesService {

	ServiceEntity saveservice(ServiceDto serviceDto,String filename);
}
