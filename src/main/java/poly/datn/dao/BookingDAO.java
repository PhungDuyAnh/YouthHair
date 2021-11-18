package poly.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import poly.datn.entity.Booking;

import java.util.List;

public interface BookingDAO extends JpaRepository<Booking, Integer> {


    @Query(value = "SELECT b FROM Booking b WHERE b.statusbooking.id = ?1")
    List<Booking> bookingByStatus(String status);



}
