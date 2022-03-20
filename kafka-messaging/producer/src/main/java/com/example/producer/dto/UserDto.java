package com.example.producer.dto;

import lombok.Data;

@Data
public class UserDto {
    private String firstName;
    private String lastName;
    private AddressDto addressDto;
}
