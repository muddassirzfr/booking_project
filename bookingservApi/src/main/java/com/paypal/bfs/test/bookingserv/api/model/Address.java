package com.paypal.bfs.test.bookingserv.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;


@Entity
@Data
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    @JsonProperty("line1")
    private String line1;


    @JsonProperty("line2")
    private String line2;

    @NotNull
    @JsonProperty("city")
    private String city;

    @NotNull
    @JsonProperty("zip_code")
    private String zip_code;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookingdto_id")
    @JsonBackReference
    private BookingDTO bookingDTO;

}
