package com.example.consumer.dto;

import com.example.consumer.model.Address;
import lombok.Data;

@Data
public class AddressDto {
    private String country;
    private String city;
    private String street;
    private String houseNumber;

    public Address toAddress() {
        return new Address(
                this.getCountry(),
                this.getCity(),
                this.getStreet(),
                this.getHouseNumber()
        );
    }
}
