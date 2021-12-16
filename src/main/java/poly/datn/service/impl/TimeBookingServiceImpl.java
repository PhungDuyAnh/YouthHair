package poly.datn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.datn.dao.TimeBookingDAO;
import poly.datn.entity.TimeBooking;
import poly.datn.service.TimeBookingService;

import java.util.List;

@Service
public class TimeBookingServiceImpl implements TimeBookingService {

    @Autowired
    TimeBookingDAO timeBookingDAO;

public List<TimeBooking> getTimeByShifts(Integer id){

    return timeBookingDAO.getTimeBookingByShift(id);
}

}
