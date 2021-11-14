package poly.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.datn.entity.Statusbooking;

public interface StatusBookingDAO extends JpaRepository<Statusbooking, String> {

}
