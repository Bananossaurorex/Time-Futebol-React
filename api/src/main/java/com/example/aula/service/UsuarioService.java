package com.example.aula.service;

import com.example.aula.exception.EmailJaCadastradoException;
import com.example.aula.model.Usuario;
import com.example.aula.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario salvar(@Valid Usuario usuario) {
        if (usuarioRepository.findByNumCamisa(usuario.getNumCamisa()).isPresent()) {
            throw new EmailJaCadastradoException("Jogador já cadastrado.");
        }

        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(@Valid Usuario usuario) {
        Usuario usuarioAtualizar = usuarioRepository.findById(usuario.getId())
                .orElseThrow(() -> new IllegalArgumentException("Jogador não encontrado."));

        usuarioAtualizar.setNome(usuario.getNome());
        usuarioAtualizar.setNumCamisa(usuario.getNumCamisa());
        usuarioAtualizar.setNumCamisa(usuario.getNumCamisa());

        return usuarioRepository.save(usuarioAtualizar);
    }

    public void excluir(Long id) {
        Usuario usuarioExcluir = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));

        usuarioRepository.deleteById(usuarioExcluir.getId());
    }

}
