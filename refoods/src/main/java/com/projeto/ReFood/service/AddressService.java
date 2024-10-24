package com.projeto.ReFood.service;

import com.projeto.ReFood.dto.AddressDTO;
import com.projeto.ReFood.exception.GlobalExceptionHandler;
import com.projeto.ReFood.model.*;
import com.projeto.ReFood.repository.AddressRepository;
import com.projeto.ReFood.security.JwtTokenProvider;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Validated
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UtilityService utilityService;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Transactional(readOnly = true)
    public List<AddressDTO> getAllAddresses() {
        return addressRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<AddressDTO> getAddressesByUserId(String token) {
        Long id = jwtTokenProvider.extractUserId(token);

        return addressRepository
                .findAddressesByUserId(id)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AddressDTO getAddressByUserIdAndToken(String token, long addressId) {
        Long id = jwtTokenProvider.extractUserId(token);

        Address address = addressRepository.findByIdAndUserId(addressId, id)
                .orElseThrow(() -> {
                    return new GlobalExceptionHandler.NotFoundException();
                });
        return convertToDTO(address);
    }

    @Transactional(readOnly = true)
    public AddressDTO getAddressById(Long addressId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> {
                    return new GlobalExceptionHandler.NotFoundException();
                });
        return convertToDTO(address);
    }

    @Transactional
    public AddressDTO createAddress(@Valid AddressDTO addressDTO, String token, User user, Restaurant restaurant, Order order) {
        Long id = jwtTokenProvider.extractUserId(token);


        Address address = new Address();

        address.setCep(addressDTO.cep());
        address.setState(addressDTO.state());
        address.setDistrict(addressDTO.district());
        address.setCity(addressDTO.city());
        address.setType(addressDTO.type());
        address.setStreet(addressDTO.street());
        address.setNumber(addressDTO.number());
        address.setStandard(false);
        address.setComplement(addressDTO.complement());
        address.setAddressType(EnumAddressType.valueOf(addressDTO.addressType().toString()));

        List<AddressDTO> addresses = getAddressesByUserId(token);
        if (addresses.isEmpty()) {
            address.setStandard(true);
        }

        if (addressDTO.userId() != null || id != null) {
            Long userId = addressDTO.userId();
            if (userId == null) {
                userId = id;
            }
            utilityService.associateUser(address::setUser, userId);
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
    public AddressDTO updateAddress(String token, Long addressId, @Valid AddressDTO addressDTO) {
        Long id = jwtTokenProvider.extractUserId(token);
        Address address = addressRepository.findByIdAndUserId(addressId, id)
                .orElseThrow(() -> {
                    return new GlobalExceptionHandler.NotFoundException();
                });

        address.setStreet(addressDTO.street());
        address.setNumber(addressDTO.number());
        address.setDistrict(addressDTO.district());
        address.setType(addressDTO.type());
        address.setCity(addressDTO.city());
        address.setComplement(addressDTO.complement());
        address.setAddressType(EnumAddressType.valueOf(addressDTO.addressType().toString()));
        address.setCep(addressDTO.cep());
        address.setState(addressDTO.state());

        address = addressRepository.save(address);

        return convertToDTO(address);
    }

    @Transactional
    public void updatePartialAddress(String token, Long addressId) {
        Long userId = jwtTokenProvider.extractUserId(token);
        addressRepository.findByIdAndUserId(addressId, userId)
                .orElseThrow(() -> {
                    return new GlobalExceptionHandler.NotFoundException();
                });

        List<Address> addressList = addressRepository.findAddressesByUserId(userId);

        addressList.forEach((a) -> {
            if (a.isStandard()) {
                a.setStandard(false);
            }
            if (a.getAddressId().equals(addressId)) {
                a.setStandard(true);
            }
        });

        addressRepository.saveAll(addressList);
    }

    @Transactional
    public AddressDTO getAddressDefault(String token) {
        Long userId = jwtTokenProvider.extractUserId(token);
        Address address = addressRepository.findByUserIdAndIsStandardTrue(userId)
                .orElse(null);

        return address != null ? convertToDTO(address) : null;
    }


    @Transactional
    public void deleteAddress(String token, Long addressId) {
        Long id = jwtTokenProvider.extractUserId(token);
        Optional<Address> address = addressRepository.findByIdAndUserId(addressId, id);

        if (!addressRepository.existsById(addressId)) {
            throw new GlobalExceptionHandler.NotFoundException();
        }
        addressRepository.deleteById(address.get().getAddressId());
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