package com.projeto.ReFood.dto;

import com.projeto.ReFood.model.EnumAddressType;

public record AddressDetailsDTO(
    Long addressId,

    String cep,

    String state,

    String city,

    String type,

    String district,

    String street,

    String number,

    String complement, // opcional

    EnumAddressType addressType,

    boolean isStandard// default = false

) {}