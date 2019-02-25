package com.listaContatos.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.listaContatos.demo.model.Contact;
import com.listaContatos.demo.services.ContactService;

@RestController
@RequestMapping(value="/contacts")
public class ContactResource {
	
	@Autowired
	private ContactService contactService; 
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> findContact(@PathVariable Integer id) {
		
		Contact obj = contactService.searchContact(id);
		
		return ResponseEntity.ok().body(obj); 
	}
	
	@PostMapping
	public ResponseEntity addContact(@RequestBody Contact contact) {
		return ResponseEntity.ok(this.contactService.saveContact(contact));
	}
	
	@PutMapping
	public ResponseEntity editContact(@RequestBody Contact contact) {
		if(this.contactService.searchContact(contact.getId()) == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(this.contactService.saveContact(contact));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteContact(@PathVariable Integer id) {
		this.contactService.deleteContact(id);
		return ResponseEntity.ok("Contato deletado com sucesso");
	}
	
	@GetMapping
	public ResponseEntity getContacts() {
		List<Contact> contacts = this.contactService.listContacts();
		if(contacts.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(contacts);
	}
	
	

}
