package com.projeto.ReFood.service;

import com.projeto.ReFood.dto.UserDTO;
import com.projeto.ReFood.model.User;
import com.projeto.ReFood.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public List<UserDTO> getAllUsers() {
    return userRepository
        .findAll()
        .stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }

  public UserDTO getUserById(int id_user) {
    Optional<User> user = userRepository.findById(id_user);
    return user.map(this::convertToDTO).orElse(null);
  }

  public UserDTO createUser(UserDTO userDTO) {
    User user = new User();

    user.setName(userDTO.getName());
    user.setSurname(userDTO.getSurname());
    user.setCpf(userDTO.getCpf());
    user.setEmail(userDTO.getEmail());
    user.setPhone(userDTO.getPhone());
    userRepository.save(user);
    return convertToDTO(user);
  }

  public UserDTO updateUser(int id_user, UserDTO userDTO) {
    Optional<User> userOptional = userRepository.findById(id_user);

    if (userOptional.isPresent()) {
      User user = userOptional.get();

      user.setName(userDTO.getName());
      user.setSurname(userDTO.getSurname());
      user.setCpf(userDTO.getCpf());
      user.setEmail(userDTO.getEmail());
      user.setPhone(userDTO.getPhone());

      userRepository.save(user);

      return convertToDTO(user);
    }

    return null;
  }

  public void deleteUser(int id_user) {
    userRepository.deleteById(id_user);
  }

  private UserDTO convertToDTO(User user) {
    UserDTO userDTO = new UserDTO();

    userDTO.setId_user(user.getId_user());
    userDTO.setName(user.getName());
    userDTO.setSurname(user.getSurname());
    userDTO.setCpf(user.getCpf());
    userDTO.setEmail(user.getEmail());
    userDTO.setPhone(user.getPhone());

    return userDTO;
  }
}