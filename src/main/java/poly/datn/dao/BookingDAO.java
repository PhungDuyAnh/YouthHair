package poly.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.datn.entity.Booking;

public interface BookingDAO extends JpaRepository<Booking, Integer> {

}
