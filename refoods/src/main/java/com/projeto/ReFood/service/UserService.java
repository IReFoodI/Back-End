package com.projeto.ReFood.service;

import com.projeto.ReFood.dto.UserDTO;
import com.projeto.ReFood.dto.UserUpdateResponse;
import com.projeto.ReFood.exception.BadRequestException;
import com.projeto.ReFood.exception.GlobalExceptionHandler.EmailAlreadyExistsException;
import com.projeto.ReFood.exception.GlobalExceptionHandler.NotFoundException;
import com.projeto.ReFood.model.CustomUserDetails;
import com.projeto.ReFood.model.User;
import com.projeto.ReFood.repository.UserRepository;

import com.projeto.ReFood.security.JwtTokenProvider;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Validated
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UtilityService utilityService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final CustomUserDetailsService userDetailsService;

    @Transactional(readOnly = true)
    public List<UserDTO> getAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UserDTO getUserById(String token) {
        Long userId = jwtTokenProvider.extractUserId(token);
        // Optional<User> response = userRepository.findById(userId);
        UserDTO dto = userRepository.findById(userId)
                .map(this::convertToDTO)
                .orElseThrow(() -> new NotFoundException());
        return dto;
    }

    @Transactional(readOnly = true)
    public UserDTO getUserInfoByToken(String token) {
        Long userId = jwtTokenProvider.extractUserId(token);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException());

        return new UserDTO(
                user.getUserId(),
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                null, // SENHA...
                user.getDateCreation(),
                user.getLastLogin());
    }

    @Transactional
    public UserDTO createUser(@Valid UserDTO userDTO) {

        if (!utilityService.isEmailUnique(userDTO.email())) {
            throw new EmailAlreadyExistsException();
        }

        User user = convertToEntity(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setDateCreation(LocalDateTime.now());
        user.setLastLogin(null);

        return convertToDTO(userRepository.save(user));
    }

    @Transactional
    public UserUpdateResponse updateUser(String token, @Valid UserDTO userDTO) {
        Long userId = jwtTokenProvider.extractUserId(token);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException());

        if (!utilityService.isEmailUnique(userDTO.email()) && !Objects.equals(user.getEmail(), userDTO.email())) {
            throw new EmailAlreadyExistsException();
        }

        CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(user.getEmail());
        userDetails.setEmail(userDTO.email());
        String role = userDetails.getAuthorities().stream().findFirst().get().getAuthority();
        if (!role.equals("ROLE_USER")) {
            throw new BadRequestException("Essa conta não é de usuário");
        }

        String jwt = jwtTokenProvider.generateToken(userDetails, userId);

        user.setName(userDTO.name());
        user.setEmail(userDTO.email());
        user.setPhone(userDTO.phone());

        return new UserUpdateResponse(jwt, convertToDTO(userRepository.save(user)));
    }

    @Transactional
    public void deleteUser(String token) {
        Long userId = jwtTokenProvider.extractUserId(token);
        if (!userRepository.existsById(userId)) {
            throw new NotFoundException();
        }
        userRepository.deleteById(userId);
    }

    private User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setUserId(userDTO.userId());
        user.setName(userDTO.name());
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
                user.getEmail(),
                user.getPhone(),
                null, // Não expor a senha
                user.getDateCreation(),
                user.getLastLogin());
    }

}