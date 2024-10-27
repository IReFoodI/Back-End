package com.projeto.ReFood.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_addresses")
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "address_id")
  private Long addressId;

  @NotBlank(message = "O CEP é obrigatório.")
  @Pattern(regexp = "\\d{8}", message = "O formato do CEP deve ser 12345678.")
  @Column(nullable = false)
  private String cep;

  @NotBlank(message = "O estado é obrigatório.")
  @Size(min = 2, max = 2, message = "O estado deve ter exatamente 2 letras.")
  @Column(nullable = false)
  private String state;

  @NotBlank(message = "A cidade é obrigatória.")
  @Size(min = 2, message = "A cidade deve ter no mínimo 2 letras.")
  @Column(nullable = false)
  private String city;

  @NotBlank(message = "O bairro é obrigatório.")
  @Column(nullable = false)
  private String district;

  @NotBlank(message = "A rua é obrigatória.")
  @Column(nullable = false)
  private String street;

  @NotBlank(message = "O número é obrigatório.")
  @Column(nullable = false)
  private String number;

  @NotBlank(message = "O tipo é obrigatório.")
  @Column(nullable = false)
  private String type;

  @Column
  private String complement;

  @NotNull(message = "O tipo de endereço é obrigatório.")
  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private EnumAddressType addressType;

  @Column(nullable = false)
  private boolean isStandard; // default = false

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "restaurant_id")
  private Restaurant restaurant;

  @OneToOne(mappedBy = "associatedAddress")
  private Order associatedOrder;
}
