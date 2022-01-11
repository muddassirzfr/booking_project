package com.paypal.bfs.test.bookingserv.api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class BookingDTO {
    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    @JsonProperty("first_name")
    @JsonPropertyDescription("First name")
    private String firstName;

    @NotNull
    @JsonProperty("last_name")
    @JsonPropertyDescription("Last name")
    private String lastName;

    @NotNull
    @JsonProperty("dob")
    @JsonPropertyDescription("Date of Birth")
    private LocalDate dob;

    @NotNull
    @JsonProperty("checkin_datetime")
    private LocalDateTime checkinDatetime;

    @NotNull
    @JsonProperty("checkout_datetime")
    private LocalDateTime checkoutDatetime;

    @NotNull
    @JsonProperty("total_price")
    private Double totalPrice;

    @NotNull
    @JsonProperty("deposit")
    private Double deposit;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bookingDTO")
    @JsonManagedReference
    private Address address;

}
