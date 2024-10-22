package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.AddressService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

import com.projeto.ReFood.dto.AddressDTO;
import com.projeto.ReFood.exception.GlobalExceptionHandler.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Operation(
            summary = "Lista todos os endereços",
            description = "Retorna uma lista de todos os endereços disponíveis no sistema.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de endereços retornada com sucesso"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            }
    )
    @GetMapping
    public ResponseEntity<List<AddressDTO>> listAllAddresses() {
        List<AddressDTO> addresses = addressService.getAllAddresses();
        return ResponseEntity.ok(addresses);
    }

    @Operation(
            summary = "Busca um endereço por ID",
            description = "Retorna os detalhes de um endereço específico com base no ID fornecido.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Endereço encontrado e retornado com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Endereço não encontrado")
            }
    )
    @GetMapping("/{addressId}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable Long addressId) {
        AddressDTO addressDTO = addressService.getAddressById(addressId);
        return ResponseEntity.ok(addressDTO);
    }

    @Operation(
            summary = "Cria um novo endereço para o usuário",
            description = "Permite a criação de um novo endereço associado ao usuário autenticado. O token de autorização deve ser fornecido no cabeçalho da requisição.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Endereço criado com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Requisição inválida"),
                    @ApiResponse(responseCode = "401", description = "Usuário não autorizado")
            }
    )
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @PostMapping
    public ResponseEntity<AddressDTO> createAddress(@RequestHeader("Authorization") String token, @Valid @RequestBody AddressDTO addressDTO) {
        AddressDTO createdAddress = addressService.createAddress(addressDTO, token, null, null, null);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{addressId}")
                .buildAndExpand(createdAddress.addressId())
                .toUri();
        return ResponseEntity.created(location).body(createdAddress);
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<AddressDTO> updateAddress(@PathVariable Long addressId,
                                                    @Valid @RequestBody AddressDTO addressDTO)
            throws NotFoundException {
        AddressDTO updatedAddress = addressService.updateAddress(addressId, addressDTO);
        return ResponseEntity.ok(updatedAddress);
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long addressId) {
        addressService.deleteAddress(addressId);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Busca endereços por ID de usuário",
            description = "Retorna uma lista de endereços associados ao ID do usuário baseado no token de autorização fornecido.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Endereços retornados com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
            }
    )
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @GetMapping("/user")
    public ResponseEntity<List<AddressDTO>> getAddressByUserId(@RequestHeader("Authorization") String token) throws NotFoundException {
        List<AddressDTO> addressesDTO = addressService.getAddressesByUserId(token);
        return ResponseEntity.ok(addressesDTO);
    }

    @GetMapping("/user/me")
    public ResponseEntity<AddressDTO> getPrimaryAddressByUserToken(@RequestHeader("Authorization") String token, @PathVariable Long addressId) throws NotFoundException {
        AddressDTO addressDTO = addressService.getAddressByUserId(token);
        return ResponseEntity.ok(addressDTO);
    }


}