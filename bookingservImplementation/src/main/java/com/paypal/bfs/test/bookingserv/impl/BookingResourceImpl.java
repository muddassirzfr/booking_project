package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.BookingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingResourceImpl implements BookingResource {

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public ResponseEntity<BookingDTO> create(BookingDTO booking) {
        BookingDTO save = bookingRepository.save(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @Override
    public ResponseEntity<List<BookingDTO>> getAllBookings() {
        List<BookingDTO> bookings = bookingRepository.findAll();
        return ResponseEntity.status(HttpStatus.FOUND).body(bookings);
    }
}
