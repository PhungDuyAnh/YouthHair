package poly.datn.service;

import poly.datn.entity.TimeBooking;

import java.util.List;

public interface TimeBookingService {
    List<TimeBooking> getTimeByShifts(Integer id);
}
