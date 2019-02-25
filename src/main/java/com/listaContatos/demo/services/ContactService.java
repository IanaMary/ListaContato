package com.listaContatos.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.listaContatos.demo.model.Contact;
import com.listaContatos.demo.repositories.ContactRepository;


@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository; 
	
	public Contact searchContact(Integer id) {
		Optional<Contact> obj = contactRepository.findById(id);
		return obj.orElse(null);
	}
	
	public Contact saveContact(Contact contact) {
		return this.contactRepository.save(contact);
	}
	
	public void deleteContact(Integer id) {
		Contact contact =  this.searchContact(id);
		this.contactRepository.delete(contact);
	}
	
	public List<Contact> listContacts() {
		return this.contactRepository.findAll();
	}
	

}
