package com.servidorSpotify.ProjetoFinal.Interface;

import com.servidorSpotify.ProjetoFinal.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioModelRepository extends JpaRepository<UsuarioModel, Long> {
    Optional<UsuarioModel> findByIdSpotifyUsuario(String idSpotifyUsuario);
}

