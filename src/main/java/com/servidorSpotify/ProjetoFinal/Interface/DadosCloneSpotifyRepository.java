package com.servidorSpotify.ProjetoFinal.Interface;

import com.servidorSpotify.ProjetoFinal.Model.DadosCloneSpotifyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DadosCloneSpotifyRepository extends JpaRepository<DadosCloneSpotifyModel, Integer> {
    DadosCloneSpotifyModel findByUsuario_IdSpotifyUsuario(String idSpotifyUsuario);
}

