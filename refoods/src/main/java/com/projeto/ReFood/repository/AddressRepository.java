package com.projeto.ReFood.repository;

import com.projeto.ReFood.model.Address;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address, Long> {
  @Query(value = "SELECT * FROM TB_ADDRESSES WHERE ADDRESS_TYPE = 'USER' AND USER_ID = :userId", nativeQuery = true)
  List<Address> nativeSearchAllByUserId(Long userId);

  @Query(value = "SELECT * FROM TB_ADDRESSES WHERE ADDRESS_TYPE = 'RESTAURANT' AND RESTAURANT_ID = :restaurantId", nativeQuery = true)
  List<Address> nativeSearchAllByRestaurantId(Long restaurantId);

  @Query(value = "SELECT * FROM TB_ADDRESSES WHERE ADDRESS_TYPE = 'USER' AND USER_ID = :userId AND ADDRESS_ID = :addressId", nativeQuery = true)
  Address nativeSearchByUserIdAndAddressId(Long userId, Long addressId);

  @Query(value = "SELECT * FROM TB_ADDRESSES WHERE ADDRESS_TYPE = 'RESTAURANT' AND RESTAURANT_ID = :restaurantId AND ADDRESS_ID = :addressId", nativeQuery = true)
  Address nativeSearchByRestaurantIdAndAddressId(Long restaurantId, Long addressId);
}
