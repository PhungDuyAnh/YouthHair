package poly.datn.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import poly.datn.entity.BookingDetailView;
import poly.datn.service.BookingDetailsViewsService;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class BookingDetailsViewsRestController {
    @Autowired
    BookingDetailsViewsService bookingViewsService;

    @GetMapping("/getAllBookingViews")
    public List<BookingDetailView> getAllData(){
        return bookingViewsService.findAll();
    }

    @GetMapping("/getAllBookingViews/WFC")
    public List<BookingDetailView> getgetAllDataBystatus(){
        return bookingViewsService.findByStatusName("Chờ cắt");
    }



}
