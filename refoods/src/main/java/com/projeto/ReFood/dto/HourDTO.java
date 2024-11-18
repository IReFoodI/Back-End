package com.projeto.ReFood.dto;

import com.projeto.ReFood.model.EnumDayOfWeek;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HourDTO {
  Long id;
  EnumDayOfWeek dayOfWeek;
  String openingTime;
  String closingTime;
}
