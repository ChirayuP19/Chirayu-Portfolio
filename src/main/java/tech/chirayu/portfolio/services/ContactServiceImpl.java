package tech.chirayu.portfolio.services;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.chirayu.portfolio.dto.ContactDto;
import tech.chirayu.portfolio.entity.ContactEntity;
import tech.chirayu.portfolio.repositories.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ContactEntity saveContact(ContactDto contactDto) {

//		ContactEntity contactEntity = new ContactEntity();
//		contactEntity.setName(contactDto.getName());
//		contactEntity.setEmail(contactDto.getEmail());
//		contactEntity.setSubject(contactDto.getSubject());
//		contactEntity.setMessage(contactDto.getMessage());
//		contactEntity.setDatatime(LocalDateTime.now().toString());

		ContactEntity contactEntity = modelMapper.map(contactDto, ContactEntity.class);

		return contactRepository.save(contactEntity);

	}

	public boolean isContactEmailExist(String email) {
		return contactRepository.existsByEmail(email);
	}

	public List<ContactEntity> readAllContacts() {
		
		return contactRepository.findAll();
	}

	@Override
	public void deleteContactByID(int id) {
		contactRepository.deleteById(id);
	}

}
