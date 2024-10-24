package com.projeto.ReFood.repository;

import com.projeto.ReFood.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    @Query("SELECT a FROM Address a WHERE a.user.id = :userId")
    List<Address> findAddressesByUserId(@Param("userId") Long userId);

    @Query("SELECT a FROM Address a WHERE a.id = :addressId AND a.user.id = :userId")
    Optional<Address> findByIdAndUserId(@Param("addressId") Long addressId, @Param("userId") Long userId);

    @Query("SELECT a FROM Address a WHERE a.user.id = :userId AND a.isStandard = true")
    Optional<Address> findByUserIdAndIsStandardTrue(@Param("userId") Long userId);
}
