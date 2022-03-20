package com.example.producer.dto;

import lombok.Data;

@Data
public class AddressDto {
    private String country;
    private String city;
    private String street;
    private String houseNumber;
}
