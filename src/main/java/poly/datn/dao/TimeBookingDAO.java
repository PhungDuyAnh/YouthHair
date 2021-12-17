package poly.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import poly.datn.entity.Account;
import poly.datn.entity.Shifts;
import poly.datn.entity.TimeBooking;

import java.util.List;

public interface TimeBookingDAO extends JpaRepository<TimeBooking, Integer> {
    @Query(value = "SELECT b FROM TimeBooking b  WHERE b.shifts.id = ?1 ")
    List<TimeBooking> getTimeBookingByShift(Integer id);


}
