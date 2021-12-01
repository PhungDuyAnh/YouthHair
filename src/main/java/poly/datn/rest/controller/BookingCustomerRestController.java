package poly.datn.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import poly.datn.entity.Booking;
import poly.datn.service.BookingCustomerService;
import poly.datn.service.dto.BookingCustomerDTO;
import poly.datn.service.impl.ServiceService;

@RestController
public class BookingCustomerRestController {

    @Autowired
    BookingCustomerService bcService;

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


}
