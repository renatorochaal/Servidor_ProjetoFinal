package com.servidorSpotify.ProjetoFinal.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_spotify_usuario")
    private String idSpotifyUsuario;

    @Column(name = "imagem_url_usuario")
    private String imagemUrlUsuario;

    @Column(name = "nome_usuario")
    private String nomeUsuario;

    @OneToOne(mappedBy = "usuario")
    private DadosCloneSpotifyModel dadosCloneSpotifyModel;
    // construtores, getters e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdSpotifyUsuario() {
        return idSpotifyUsuario;
    }

    public void setIdSpotifyUsuario(String idSpotifyUsuario) {
        this.idSpotifyUsuario = idSpotifyUsuario;
    }

    public String getImagemUrlUsuario() {
        return imagemUrlUsuario;
    }

    public void setImagemUrlUsuario(String imagemUrlUsuario) {
        this.imagemUrlUsuario = imagemUrlUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public DadosCloneSpotifyModel getDadosCloneSpotifyModel() {
        return dadosCloneSpotifyModel;
    }

    public void setDadosCloneSpotifyModel(DadosCloneSpotifyModel dadosCloneSpotifyModel) {
        this.dadosCloneSpotifyModel = dadosCloneSpotifyModel;
    }

    @Override
    public String toString() {
        return "UsuarioModel{" +
                "id=" + id +
                ", idSpotifyUsuario='" + idSpotifyUsuario + '\'' +
                ", imagemUrlUsuario='" + imagemUrlUsuario + '\'' +
                ", nomeUsuario='" + nomeUsuario + '\'' +
                '}';
    }
}
