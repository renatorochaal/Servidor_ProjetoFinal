package com.servidorSpotify.ProjetoFinal.Service;

import com.servidorSpotify.ProjetoFinal.Model.ArtistaModel;

import java.util.ArrayList;
import java.util.List;

public class TopArtistasDataset {
    private List<ArtistaModel> artistas;

    public TopArtistasDataset() {
        artistas = new ArrayList<>();
    }

    public void adicionarArtista(ArtistaModel artista) {
        artistas.add(artista);
    }

    public List<ArtistaModel> getArtistas() {
        return artistas;
    }
}

