package com.servidorSpotify.ProjetoFinal.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "artista")
public class ArtistaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome_artista")
    private String nomeArtista;

    @Column(name = "imagem_url_artista")
    private String imagemUrlArtista;

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
    public String getNomeArtista() {
        return nomeArtista;
    }
    public void setNomeArtista(String nomeArtista) {
        this.nomeArtista = nomeArtista;
    }
    public String getImagemUrlArtista() {
        return imagemUrlArtista;
    }
    public void setImagemUrlArtista(String imagemUrlArtista) {
        this.imagemUrlArtista = imagemUrlArtista;
    }
    public DadosCloneSpotifyModel getDadosCloneSpotifyModel() {
        return dadosCloneSpotifyModel;
    }
    public void setDadosCloneSpotifyModel(DadosCloneSpotifyModel dadosCloneSpotifyModel) {
        this.dadosCloneSpotifyModel = dadosCloneSpotifyModel;
    }
    @Override
    public String toString() {
        return "ArtistaModel{" +
                "id=" + id +
                ", nomeArtista='" + nomeArtista + '\'' +
                ", imagemUrlArtista='" + imagemUrlArtista + '\'' +
                '}';
    }
}