package com.ifpe.encriptacaosenha.controller;

import com.ifpe.encriptacaosenha.model.UsuarioModel;
import com.ifpe.encriptacaosenha.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;

    public UsuarioController(UsuarioRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UsuarioModel>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }
    @GetMapping("/login")
    public ResponseEntity<UsuarioModel> login(@RequestBody UsuarioModel usuario){
        Optional<UsuarioModel> optionalUser = repository.findByEmail(usuario.email);
        if (optionalUser.isPresent()) {
            UsuarioModel decriptacao = optionalUser.get();
            boolean valid = encoder.matches(usuario.senha, decriptacao.getSenha());
            if(valid){
                return ResponseEntity.ok(decriptacao);
            } else{
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    @PostMapping("/salvar")
    public ResponseEntity<UsuarioModel> salvar(@RequestBody UsuarioModel usuario){
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        return ResponseEntity.ok(repository.save(usuario));
    }

}
