package com.example.consumer.dto;

import lombok.Data;

@Data
public class UserDto {
    private String firstName;
    private String lastName;
    private AddressDto address;
}
