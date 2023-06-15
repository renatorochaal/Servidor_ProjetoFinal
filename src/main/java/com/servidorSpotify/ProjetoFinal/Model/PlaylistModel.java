package com.servidorSpotify.ProjetoFinal.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "playlist")
public class PlaylistModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_playlist")
    private String namePlaylist;

    @Column(name = "uri_playlist")
    private String uriPlaylist;

    @ManyToOne
    @JoinColumn(name = "dados_clone_spotify_model_id")
    private DadosCloneSpotifyModel dadosCloneSpotifyModel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamePlaylist() {
        return namePlaylist;
    }

    public void setNamePlaylist(String namePlaylist) {
        this.namePlaylist = namePlaylist;
    }

    public String getUriPlaylist() {
        return uriPlaylist;
    }

    public void setUriPlaylist(String uriPlaylist) {
        this.uriPlaylist = uriPlaylist;
    }

    public DadosCloneSpotifyModel getDadosCloneSpotifyModel() {
        return dadosCloneSpotifyModel;
    }

    public void setDadosCloneSpotifyModel(DadosCloneSpotifyModel dadosCloneSpotifyModel) {
        this.dadosCloneSpotifyModel = dadosCloneSpotifyModel;
    }

    @Override
    public String toString() {
        return "PlaylistModel{" +
                "id=" + id +
                ", namePlaylist='" + namePlaylist + '\'' +
                ", uriPlaylist='" + uriPlaylist + '\'' +
                '}';
    }
}