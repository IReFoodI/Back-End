package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.AddressRepository;

import com.projeto.ReFood.repository.UserRepository;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.projeto.ReFood.dto.AddressDTO;
import com.projeto.ReFood.exception.GlobalExceptionHandler.NotFoundException;
import com.projeto.ReFood.model.Address;
import com.projeto.ReFood.model.EnumAddressType;
import com.projeto.ReFood.model.Order;
import com.projeto.ReFood.model.Restaurant;
import com.projeto.ReFood.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UtilityService utilityService;

    @Transactional(readOnly = true)
    public List<AddressDTO> getAllAddresses() {
        return addressRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<AddressDTO> getAddressesByUserId(Long userId) {
        return addressRepository
                .findAddressesByUserId(userId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AddressDTO getAddressById(Long addressId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new NotFoundException("Address not found with ID: " + addressId));
        return convertToDTO(address);
    }

    @Transactional
    public AddressDTO createAddress(@Valid AddressDTO addressDTO, User user, Restaurant restaurant, Order order) {
        Address address = new Address();

        address.setCep(addressDTO.cep());
        address.setState(addressDTO.state());
        address.setDistrict(addressDTO.district());
        address.setCity(addressDTO.city());
        address.setType(addressDTO.type());
        address.setStreet(addressDTO.street());
        address.setNumber(addressDTO.number());
        address.setComplement(addressDTO.complement());
        address.setAddressType(EnumAddressType.valueOf(addressDTO.addressType().toString()));
        address.setStandard(addressDTO.isStandard());

        if (addressDTO.userId() != null) {
            utilityService.associateUser(address::setUser, addressDTO.userId());
        }
        if (user != null) {
            address.setUser(user);
        }
        if (restaurant != null) {
            address.setRestaurant(restaurant);
        }
        if (order != null) {
            address.setAssociatedOrder(order);
        }

        addressRepository.save(address);
        return convertToDTO(address);
    }

    @Transactional
    public AddressDTO updateAddress(Long addressId, @Valid AddressDTO addressDTO) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new NotFoundException("Endereço não encontrado para o id: " + addressId));

        address.setStreet(addressDTO.street());
        address.setNumber(addressDTO.number());
        address.setDistrict(addressDTO.district());
        address.setType(addressDTO.type());
        address.setCity(addressDTO.city());
        address.setComplement(addressDTO.complement());
        address.setAddressType(EnumAddressType.valueOf(addressDTO.addressType().toString()));
        address.setStandard(addressDTO.isStandard());
        address.setCep(addressDTO.cep());
        address.setState(addressDTO.state());

        address = addressRepository.save(address);

        return convertToDTO(address);
    }

    @Transactional
    public void deleteAddress(Long addressId) {
        if (!addressRepository.existsById(addressId)) {
            throw new NotFoundException("Endereço não encontrado para o id: " + addressId);
        }
        addressRepository.deleteById(addressId);
    }

    public AddressDTO convertToDTO(Address address) {
        return new AddressDTO(
                address.getAddressId(),
                address.getCep(),
                address.getState(),
                address.getCity(),
                address.getType(),
                address.getDistrict(),
                address.getStreet(),
                address.getNumber(),
                address.getComplement(),
                address.getAddressType(),
                address.isStandard(),
                address.getUser() != null ? address.getUser().getUserId() : null,
                address.getRestaurant() != null ? address.getRestaurant().getRestaurantId() : null,
                address.getAssociatedOrder() != null ? address.getAssociatedOrder().getOrderId() : null);
    }

    public Address convertToEntity(AddressDTO addressDTO, User user, Restaurant restaurant, Order order) {
        Address address = new Address();
        address.setAddressId(addressDTO.addressId());
        address.setCep(addressDTO.cep());
        address.setState(addressDTO.state());
        address.setCity(addressDTO.city());
        address.setType(addressDTO.type());
        address.setDistrict(addressDTO.district());
        address.setStreet(addressDTO.street());
        address.setNumber(addressDTO.number());
        address.setComplement(addressDTO.complement());
        address.setAddressType(EnumAddressType.valueOf(addressDTO.addressType().toString()));
        address.setStandard(addressDTO.isStandard());

        if (user != null) {
            address.setUser(user);
        }
        if (restaurant != null) {
            address.setRestaurant(restaurant);
        }
        if (order != null) {
            address.setAssociatedOrder(order);
        }
        return address;
    }
}