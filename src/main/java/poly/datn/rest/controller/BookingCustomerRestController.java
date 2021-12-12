package poly.datn.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import poly.datn.entity.Booking;
import poly.datn.service.BookingContactService;
import poly.datn.service.BookingCustomerService;
import poly.datn.service.dto.BookingContactDTO;
import poly.datn.service.dto.BookingCustomerDTO;
import poly.datn.service.dto.BookingIatDTO;
import poly.datn.service.impl.ServiceService;

import java.util.List;

@RestController
public class BookingCustomerRestController {

    @Autowired
    BookingCustomerService bcService;
    
    @Autowired
    BookingContactService bookingContactService;

    @Autowired
    ServiceService serService;



    @PostMapping("rest/bookingCus")
    public ResponseEntity<BookingCustomerDTO> AddBookingInfo(@RequestBody BookingCustomerDTO bookingCustomerDTO) {
       bcService.AddInfoBookingCustomer(bookingCustomerDTO);
       return new  ResponseEntity<BookingCustomerDTO>(bookingCustomerDTO,HttpStatus.OK);
    }

    @GetMapping("rest/bookingCusByStylist/{id}")
    public Booking bookingCusByStylist(@PathVariable("id") Integer id) {
        return bcService.bookingStatusIAT(id);
    }


    @GetMapping("rest/bookingIAT")
    public List<BookingIatDTO> bookingIAT(){
        return bcService.bookingIAT();
    }

    @GetMapping("rest/checkBooking/{phone}")
    public Booking checkBooking(@PathVariable("phone") String phone){
        return bcService.checkBookingUCF(phone);
    }
    
    @PostMapping("rest/bookingContact")
    public ResponseEntity<BookingContactDTO> AddBookingInfo(@RequestBody BookingContactDTO bookingContactDTO) {
    	bookingContactService.AddInfoBookingCustomer(bookingContactDTO);
       return new ResponseEntity<BookingContactDTO>(bookingContactDTO,HttpStatus.OK);
    }
}
