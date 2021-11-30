package poly.datn.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import poly.datn.entity.Contact;

public interface ContactDAO extends JpaRepository<Contact, Integer> {

	@Query("SELECT c FROM Contact c WHERE "
			+ "c.status = ?1 "
			+ "ORDER BY c.createDate ASC")
	List<Contact> findContactStatus(Boolean status, @Param("keyword") String keyword);

}
