package com.example.orders.mapper;

import com.example.orders.dto.AddressDto;
import com.example.orders.entity.Address;

public class AddressMapper {
    public static AddressDto mapToAddressDto(Address address){
         AddressDto addressDto = new AddressDto(address.getId()
                                              , address.getCountry(),
                                              address.getTown()
                                             , address.getState()
                                             , address.getStreet(),
                                                 address.getOrders());
         return addressDto;
    }
    public static  Address mapToAddress(AddressDto addressDto){
        Address address = new Address(addressDto.getId()
                                      , addressDto.getCountry()
                                     , addressDto.getTown(),
                                       addressDto.getState(),
                                      addressDto.getStreet()
                                      ,addressDto.getOrders());
        return  address;
    }
}
