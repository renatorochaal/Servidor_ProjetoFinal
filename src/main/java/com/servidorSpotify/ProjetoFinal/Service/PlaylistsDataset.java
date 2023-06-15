package com.servidorSpotify.ProjetoFinal.Service;

import com.servidorSpotify.ProjetoFinal.Model.PlaylistModel;

import java.util.ArrayList;
import java.util.List;

public class PlaylistsDataset {
    private List<PlaylistModel> playlists;

    public PlaylistsDataset() {
        playlists = new ArrayList<>();
    }

    public void adicionarPlaylist(PlaylistModel playlist) {
        playlists.add(playlist);
    }

    public List<PlaylistModel> getPlaylists() {
        return playlists;
    }
}
