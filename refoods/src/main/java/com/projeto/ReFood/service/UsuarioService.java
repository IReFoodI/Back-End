package com.projeto.ReFood.service;

import com.projeto.ReFood.dto.UsuarioDTO;
import com.projeto.ReFood.model.Usuario;
import com.projeto.ReFood.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public List<UsuarioDTO> getAllUsuarios(){
        return usuarioRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public UsuarioDTO getUserById(int id_usuario){
        Optional<Usuario> usuario = usuarioRepository.findById(id_usuario);
        return usuario.map(this::convertToDTO).orElse(null);
    }
    
    public UsuarioDTO createUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        
        usuario.setNome(usuarioDTO.getNome());
        usuario.setSobrenome(usuarioDTO.getSobrenome());
        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setTelefone(usuarioDTO.getTelefone());
        usuarioRepository.save(usuario);
        return convertToDTO(usuario);
    }
    
    public UsuarioDTO updateUsuario(int id_usuario, UsuarioDTO usuarioDTO){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id_usuario);
        
        if(usuarioOptional.isPresent()){
            Usuario usuario = usuarioOptional.get();
            
            usuario.setNome(usuarioDTO.getNome());
            usuario.setSobrenome(usuarioDTO.getSobrenome());
            usuario.setCpf(usuarioDTO.getCpf());
            usuario.setEmail(usuarioDTO.getEmail());
            usuario.setTelefone(usuarioDTO.getTelefone());
            
            
            usuarioRepository.save(usuario);
            
            return convertToDTO(usuario);
        }
        
        return null;
    }
    
    public void deleteUsuario(int id_usuario){
        usuarioRepository.deleteById(id_usuario);
    }
    
    private UsuarioDTO convertToDTO(Usuario usuario){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        
        usuarioDTO.setId_usuario(usuario.getId_usuario());
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setSobrenome(usuario.getSobrenome());
        usuarioDTO.setCpf(usuario.getCpf());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setTelefone(usuario.getTelefone());
        
        return usuarioDTO;
    }
}