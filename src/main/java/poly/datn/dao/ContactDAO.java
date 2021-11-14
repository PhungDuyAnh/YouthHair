package poly.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.datn.entity.Contact;

public interface ContactDAO extends JpaRepository<Contact, Integer> {

}
