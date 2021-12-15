package poly.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import poly.datn.entity.Account;
import poly.datn.entity.TimeBooking;

public interface TimeBookingDAO extends JpaRepository<TimeBooking, Integer> {

}
