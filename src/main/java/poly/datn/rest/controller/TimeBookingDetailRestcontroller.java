package poly.datn.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import poly.datn.dao.TimeBookingDetailDAO;
import poly.datn.entity.TimeBookingDetail;

import java.util.List;


@RestController
@RequestMapping("/rest/getAllTimeBookingDetail")
public class TimeBookingDetailRestcontroller {
    @Autowired
    TimeBookingDetailDAO timeBookingDetailDAO;
    @GetMapping
    public List<TimeBookingDetail> getAllTimeBookingDetail(){
        return timeBookingDetailDAO.findAll();
    }
}
