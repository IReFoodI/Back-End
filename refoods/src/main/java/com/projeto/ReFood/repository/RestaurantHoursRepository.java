package com.projeto.ReFood.repository;

import com.projeto.ReFood.model.EnumDayOfWeek;
import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.ReFood.model.RestaurantHours;

import java.util.Arrays;
import java.util.List;

public interface RestaurantHoursRepository extends JpaRepository<RestaurantHours, Long> {
    List<RestaurantHours> findByDayOfWeek(EnumDayOfWeek dayOfWeek);

}
