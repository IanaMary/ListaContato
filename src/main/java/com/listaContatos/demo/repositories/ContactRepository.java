package com.listaContatos.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.listaContatos.demo.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
