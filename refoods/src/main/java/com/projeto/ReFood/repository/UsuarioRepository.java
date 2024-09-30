package com.projeto.ReFood.repository;

import com.projeto.ReFood.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {}
