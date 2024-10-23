package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.AddressRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.projeto.ReFood.dto.AddressDTO;
import com.projeto.ReFood.exception.GlobalExceptionHandler.ForbiddenException;
import com.projeto.ReFood.exception.GlobalExceptionHandler.NotFoundException;
import com.projeto.ReFood.model.Address;
import com.projeto.ReFood.model.EnumAddressType;
import com.projeto.ReFood.model.Order;
import com.projeto.ReFood.model.Restaurant;
import com.projeto.ReFood.model.User;
import com.projeto.ReFood.model.UserInfo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class AddressService {

  @Autowired
  private AddressRepository addressRepository;

  @Autowired
  private AuthService authService;

  @Transactional(readOnly = true)
  public List<AddressDTO> getAllAddresses() {
    return addressRepository
        .findAll()
        .stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  public List<AddressDTO> getAllUserAddresses() {
    UserInfo currentUserInfo = authService.getCurrentUserInfo();

    if (currentUserInfo.getId() == null) {
      throw new ForbiddenException();
    }

    List<Address> addresses;

    if (currentUserInfo.getRole().equals("ROLE_USER")) {
      addresses = addressRepository.nativeSearchAllByUserId(currentUserInfo.getId());

    } else if (currentUserInfo.getRole().equals("ROLE_RESTAURANT")) {
      addresses = addressRepository.nativeSearchAllByRestaurantId(currentUserInfo.getId());

    } else {
      throw new ForbiddenException();
    }

    List<AddressDTO> addressDTOs = addresses.stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());

    return addressDTOs;
  }

  @Transactional(readOnly = true)
  public AddressDTO getAddressById(Long addressId) {
    Address address = addressRepository.findById(addressId)
        .orElseThrow(() -> new NotFoundException());
    return convertToDTO(address);
  }

  @Transactional(readOnly = true)
  public AddressDTO getUserAddressById(Long addressId) {
    UserInfo currentUserInfo = authService.getCurrentUserInfo();

    if (currentUserInfo.getId() == null) {
      throw new ForbiddenException();
    }

    Address address;

    if (currentUserInfo.getRole().equals("ROLE_USER")) {
      address = addressRepository
          .nativeSearchByUserIdAndAddressId(currentUserInfo.getId(), addressId);

    } else if (currentUserInfo.getRole().equals("ROLE_RESTAURANT")) {
      address = addressRepository
          .nativeSearchByRestaurantIdAndAddressId(currentUserInfo.getId(), addressId);

    } else {
      throw new ForbiddenException();
    }

    if (address == null) {
      throw new NotFoundException();
    }

    AddressDTO addressDTO;
    addressDTO = convertToDTO(address);

    return addressDTO;
  }

  @Transactional
  public AddressDTO createAddress(@Valid AddressDTO addressDTO, User user, Restaurant restaurant, Order order) {
    Address address = new Address();

    address.setCep(addressDTO.cep());
    address.setState(addressDTO.state());
    address.setDistrict(addressDTO.district());
    address.setStreet(addressDTO.street());
    address.setNumber(addressDTO.number());
    address.setComplement(addressDTO.complement());
    address.setAddressType(EnumAddressType.valueOf(addressDTO.addressType()));
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

    addressRepository.save(address);
    return convertToDTO(address);
  }

  @Transactional
  public AddressDTO updateAddress(Long addressId, @Valid AddressDTO addressDTO) {
    Address address = addressRepository.findById(addressId)
        .orElseThrow(() -> new NotFoundException());

    address.setStreet(addressDTO.street());
    address.setNumber(addressDTO.number());
    address.setDistrict(addressDTO.district());
    address.setComplement(addressDTO.complement());
    address.setAddressType(EnumAddressType.valueOf(addressDTO.addressType()));
    address.setStandard(addressDTO.isStandard());
    address.setCep(addressDTO.cep());
    address.setState(addressDTO.state());

    address = addressRepository.save(address);

    return convertToDTO(address);
  }

  @Transactional
  public void deleteAddress(Long addressId) {
    if (!addressRepository.existsById(addressId)) {
      throw new NotFoundException();
    }
    addressRepository.deleteById(addressId);
  }

  public AddressDTO convertToDTO(Address address) {
    return new AddressDTO(
        address.getAddressId(),
        address.getCep(),
        address.getState(),
        address.getDistrict(),
        address.getStreet(),
        address.getNumber(),
        address.getComplement(),
        address.getAddressType().name(),
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
    address.setDistrict(addressDTO.district());
    address.setStreet(addressDTO.street());
    address.setNumber(addressDTO.number());
    address.setComplement(addressDTO.complement());
    address.setAddressType(EnumAddressType.valueOf(addressDTO.addressType()));
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