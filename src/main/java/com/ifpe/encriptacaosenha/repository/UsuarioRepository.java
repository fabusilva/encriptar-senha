package com.ifpe.encriptacaosenha.repository;

import com.ifpe.encriptacaosenha.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
    Optional<UsuarioModel> findByEmail(String email);
}
