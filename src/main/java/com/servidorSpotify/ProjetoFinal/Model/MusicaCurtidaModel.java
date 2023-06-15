package com.servidorSpotify.ProjetoFinal.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "musica_curtida")
public class MusicaCurtidaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome_album")
    private String nomeAlbum;

    @Column(name = "nome_do_artista")
    private String nomeDoArtista;

    @Column(name = "nome_musica")
    private String nomeMusica;

    @ManyToOne
    @JoinColumn(name = "dados_clone_spotify_model_id")
    private DadosCloneSpotifyModel dadosCloneSpotifyModel;

    // Getters e setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeAlbum() {
        return nomeAlbum;
    }

    public void setNomeAlbum(String nomeAlbum) {
        this.nomeAlbum = nomeAlbum;
    }

    public String getNomeDoArtista() {
        return nomeDoArtista;
    }

    public void setNomeDoArtista(String nomeDoArtista) {
        this.nomeDoArtista = nomeDoArtista;
    }

    public String getNomeMusica() {
        return nomeMusica;
    }

    public void setNomeMusica(String nomeMusica) {
        this.nomeMusica = nomeMusica;
    }

    public DadosCloneSpotifyModel getDadosCloneSpotifyModel() {
        return dadosCloneSpotifyModel;
    }

    public void setDadosCloneSpotifyModel(DadosCloneSpotifyModel dadosCloneSpotifyModel) {
        this.dadosCloneSpotifyModel = dadosCloneSpotifyModel;
    }

    @Override
    public String toString() {
        return "MusicasCurtidasModel{" +
                "id=" + id +
                ", nomeAlbum='" + nomeAlbum + '\'' +
                ", nomeMusica='" + nomeMusica + '\'' +
                ", nomeDoArtista='" + nomeDoArtista + '\'' +

                '}';
    }
}

