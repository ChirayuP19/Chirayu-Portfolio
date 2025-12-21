package tech.chirayu.portfolio.services;

import java.util.List;

import tech.chirayu.portfolio.dto.ContactDto;
import tech.chirayu.portfolio.entity.ContactEntity;

public interface ContactService {

	ContactEntity saveContact(ContactDto contactDto);

	boolean isContactEmailExist(String email);
	
	List<ContactEntity> readAllContacts();
	
	void deleteContactByID(int  id);
	
	
}
