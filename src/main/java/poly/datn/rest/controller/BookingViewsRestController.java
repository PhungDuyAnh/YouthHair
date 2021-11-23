package poly.datn.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import poly.datn.entity.BookingView;
import poly.datn.service.BookingViewsService;

import java.util.List;

@RestController
@RequestMapping("/rest/bookingviews")
public class BookingViewsRestController {
    @Autowired
    BookingViewsService bookingViewsService;
    @GetMapping("/WFC")
    public List<BookingView> getAllDataWFC(){
        return bookingViewsService.findByStatusName("Chờ cắt");
    }

    @GetMapping("/CAN")
    public List<BookingView> getAllDataCAN(){
        return bookingViewsService.findByStatusName("Huỷ đơn");
    }

    @GetMapping("/CPM")
    public List<BookingView> getAllDataCPM(){
        return bookingViewsService.findByStatusName("Đã thanh toán");
    }

    @GetMapping("/IAT")
    public List<BookingView> getAllDataIAT(){
        return bookingViewsService.findByStatusName("Đang cắt");
    }

    @GetMapping("/UCF")
    public List<BookingView> getAllDataUCF(){
        return bookingViewsService.findByStatusName("Chưa xác nhận");
    }

    @GetMapping("/WFP")
    public List<BookingView> getAllDataWFP(){
        return bookingViewsService.findByStatusName("Chờ thanh toán");
    }


}
