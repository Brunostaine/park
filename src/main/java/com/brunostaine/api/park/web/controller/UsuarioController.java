package com.brunostaine.api.park.web.controller;

import com.brunostaine.api.park.entity.Usuario;
import com.brunostaine.api.park.services.UsuarioService;
import com.brunostaine.api.park.web.dto.UsuarioCreateDTO;
import com.brunostaine.api.park.web.dto.UsuarioResponseDTO;
import com.brunostaine.api.park.web.dto.UsuarioSenhaDTO;
import com.brunostaine.api.park.web.dto.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> create(@RequestBody UsuarioCreateDTO createDTO){
       Usuario user = usuarioService.salvar(UsuarioMapper.toUsuario(createDTO));
       return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> getById(@PathVariable Long id){
        Usuario user = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(UsuarioMapper.toDto(user));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePassword(@PathVariable Long id, @RequestBody UsuarioSenhaDTO dto){
        Usuario user = usuarioService.editarSenha(id, dto.getSenhaAtual(), dto.getNovaSenha(), dto.getConfirmaSenha());
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity <List<Usuario>> getAll(){
        List <Usuario> users = usuarioService.buscarTodos();
        return ResponseEntity.ok(users);
    }
}
