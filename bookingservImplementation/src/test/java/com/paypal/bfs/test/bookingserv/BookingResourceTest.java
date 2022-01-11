package com.paypal.bfs.test.bookingserv;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.BookingDTO;
import com.paypal.bfs.test.bookingserv.impl.BookingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookingResourceTest {
    private static final String API_1_0_BOOKING = "/v1/bfs/booking";

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    private BookingRepository bookingRepository;

    @Test
    public void postUser_whenUserIsValid_userSavedToDB() {
        BookingDTO booking = createValidBooking();
        System.out.println("here");
        postBooking(booking, Object.class);

        assertThat(bookingRepository.count()).isEqualTo(1);

    }


    private BookingDTO createValidBooking() {
        BookingDTO booking = new BookingDTO();
        Address ad = new Address();
        ad.setLine1("KMR Landmark");
        ad.setLine2("");
        ad.setCity("Bengaluru");
        ad.setZip_code("560017");
        booking.setAddress(ad);
        booking.setFirstName("Muddassir");
        booking.setLastName("Zafar");
        booking.setDob(LocalDate.of(1995,11,28));
        booking.setCheckinDatetime(LocalDateTime.now());
        booking.setCheckoutDatetime(LocalDateTime.now());
        booking.setTotalPrice(200.0);
        booking.setDeposit(50.0);
        return booking;
    }

    private <T> ResponseEntity<T> postBooking(Object reqObj, Class<T> resObj) {
        System.out.println("her211111");
        System.out.println(testRestTemplate);
        return testRestTemplate.postForEntity(API_1_0_BOOKING, reqObj, resObj);
    }
}
