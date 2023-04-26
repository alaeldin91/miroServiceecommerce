package com.example.orders.mapper;

import com.example.orders.dto.AddressDto;
import com.example.orders.entity.Address;

public class AddressMapper {
    public static AddressDto mapToAddressDto(Address address){
         AddressDto addressDto = new AddressDto(address.getId()
                                              , address.getCountryName(),
                                              address.getTownName()
                                             , address.getStateName()
                                             , address.getStreetName());
         return addressDto;
    }
    public static  Address mapToAddress(AddressDto addressDto){
        Address address = new Address(addressDto.getId()
                                      , addressDto.getCountryName()
                                     , addressDto.getTownName(),
                                       addressDto.getStateName(),
                                      addressDto.getStreetName());
        return  address;
    }
}
