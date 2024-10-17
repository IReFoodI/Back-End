package com.projeto.ReFood.service;

import com.projeto.ReFood.dto.UserDTO;
import com.projeto.ReFood.exception.EmailAlreadyExistsException;
import com.projeto.ReFood.exception.NotFoundException;
import com.projeto.ReFood.model.User;
import com.projeto.ReFood.repository.UserRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final UtilityService utilityService;
  private final PasswordEncoder passwordEncoder;

  @Transactional(readOnly = true)
  public List<UserDTO> getAllUsers() {
    return userRepository
        .findAll()
        .stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  public UserDTO getUserById(Long userId) throws NotFoundException {
    return userRepository.findById(userId)
        .map(this::convertToDTO)
        .orElseThrow(() -> new NotFoundException("Usuário não encontrado com ID: " + userId));
  }

  @Transactional
  public UserDTO createUser(@Valid UserDTO userDTO) {

    if (!utilityService.isEmailUnique(userDTO.email())) {
      throw new EmailAlreadyExistsException("O email já está cadastrado.");
    }

    User user = convertToEntity(userDTO);
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.setDateCreation(LocalDateTime.now());
    user.setLastLogin(null);

    return convertToDTO(userRepository.save(user));
  }

  @Transactional
  public UserDTO updateUser(Long userId, @Valid UserDTO userDTO) throws NotFoundException {
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException("Usuário não encontrado com ID: " + userId));

    if (!utilityService.isEmailUnique(userDTO.email())) {
      throw new EmailAlreadyExistsException("O email já está cadastrado.");
    }

    user.setName(userDTO.name());
    user.setSurname(userDTO.surname());
    user.setEmail(userDTO.email());
    user.setPhone(userDTO.phone());

    return convertToDTO(userRepository.save(user));
  }

  @Transactional
  public void deleteUser(Long userId) throws NotFoundException {
    if (!userRepository.existsById(userId)) {
      throw new NotFoundException("Usuário não encontrado com ID: " + userId);
    }
    userRepository.deleteById(userId);
  }

  private User convertToEntity(UserDTO userDTO) {
    User user = new User();
    user.setUserId(userDTO.userId());
    user.setName(userDTO.name());
    user.setSurname(userDTO.surname());
    user.setEmail(userDTO.email());
    user.setPhone(userDTO.phone());
    user.setPassword(userDTO.password());
    user.setDateCreation(userDTO.dateCreation());
    user.setLastLogin(userDTO.lastLogin());
    return user;
  }

  private UserDTO convertToDTO(User user) {
    return new UserDTO(
        user.getUserId(),
        user.getName(),
        user.getSurname(),
        user.getEmail(),
        user.getPhone(),
        null, // user.getPassword(), // Não expor a senha
        user.getDateCreation(),
        user.getLastLogin());
  }

}