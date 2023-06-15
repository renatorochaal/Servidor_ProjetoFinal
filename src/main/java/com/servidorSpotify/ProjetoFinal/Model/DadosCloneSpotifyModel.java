package com.servidorSpotify.ProjetoFinal.Model;

import com.servidorSpotify.ProjetoFinal.Controller.CloneSpotifyController;
import jakarta.persistence.*;
import net.sf.jasperreports.engine.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.mysql.cj.conf.PropertyKey.logger;

@Entity
@Table(name = "dados_clone_spotify_model")
public class DadosCloneSpotifyModel {
    private static final Logger logger = LoggerFactory.getLogger(CloneSpotifyController.class);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private UsuarioModel usuario;

    @OneToMany(mappedBy = "dadosCloneSpotifyModel", cascade = CascadeType.ALL)
    private List<ArtistaModel> topArtistas;

    @OneToMany(mappedBy = "dadosCloneSpotifyModel", cascade = CascadeType.ALL)
    private List<PlaylistModel> playlists;

    @OneToMany(mappedBy = "dadosCloneSpotifyModel", cascade = CascadeType.ALL)
    private List<MusicaCurtidaModel> musicasCurtidas;
    @OneToMany(mappedBy = "dadosCloneSpotifyModel", cascade = CascadeType.ALL)
    private List<CarrinhoModel> carrinho;

    public List<CarrinhoModel> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(List<CarrinhoModel> carrinho) {
        this.carrinho = carrinho;
    }
    private void setValorTotal(CarrinhoModel valorTotal) {
        if (this.carrinho == null) {
            this.carrinho = new ArrayList<>();
        }
        this.carrinho.add(valorTotal);
    }


    // construtores, getters e setters
    public String getIdSpotifyUsuario() {
        return usuario.getIdSpotifyUsuario();
    }

    public String getImagemUrlUsuario() {
        return usuario.getImagemUrlUsuario();
    }

    public String getNomeUsuario() {
        return usuario.getNomeUsuario();
    }


    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public List<ArtistaModel> getTopArtistas() {
        return topArtistas;
    }

    public void setTopArtistas(List<ArtistaModel> topArtistas) {
        this.topArtistas = topArtistas;
    }

    public List<PlaylistModel> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<PlaylistModel> playlists) {
        this.playlists = playlists;
    }

    public List<MusicaCurtidaModel> getMusicasCurtidas() {
        return musicasCurtidas;
    }

    public void setMusicasCurtidas(List<MusicaCurtidaModel> musicasCurtidas) {
        this.musicasCurtidas = musicasCurtidas;
    }

    public void receberDados(Map<String, Object> dados) {
        logger.info("Extraindo dados do mapa de dados");
        Map<String, Object> usuarioMap = (Map<String, Object>) dados.get("usuario");
        UsuarioModel usuario = new UsuarioModel();
        usuario.setIdSpotifyUsuario((String) usuarioMap.get("idSpotifyUsuario"));
        usuario.setImagemUrlUsuario((String) usuarioMap.get("imagemUrlUsuario"));
        usuario.setNomeUsuario((String) usuarioMap.get("nomeUsuario"));
        usuario.setDadosCloneSpotifyModel(this);
        this.setUsuario(usuario);
        logger.info("Usuário extraído: {}", usuario);

        List<Map<String, Object>> topArtistasList = (List<Map<String, Object>>) dados.get("topArtistas");
        if (topArtistasList != null) {
            List<ArtistaModel> topArtistas = new ArrayList<>();
            for (Map<String, Object> artistaMap : topArtistasList) {
                ArtistaModel artista = new ArtistaModel();
                artista.setNomeArtista((String) artistaMap.get("nomeArtista"));
                artista.setImagemUrlArtista((String) artistaMap.get("imagemUrlArtista"));
                artista.setDadosCloneSpotifyModel(this);
                topArtistas.add(artista);
            }
            this.setTopArtistas(topArtistas);
            logger.info("Top artistas extraídos: {}", topArtistas);
        }
        List<Map<String, Object>> playlistsList = (List<Map<String, Object>>) dados.get("playlists");
        if (playlistsList != null) {
            List<PlaylistModel> playlists = new ArrayList<>();
            for (Map<String, Object> playlistMap : playlistsList) {
                PlaylistModel playlist = new PlaylistModel();
                playlist.setNamePlaylist((String) playlistMap.get("namePlaylist"));
                playlist.setUriPlaylist((String) playlistMap.get("uriPlaylist"));
                playlist.setDadosCloneSpotifyModel(this);
                playlists.add(playlist);
            }
            this.setPlaylists(playlists);
            logger.info("Playlist extraídos: {}", playlists);
        }
        List<Map<String, Object>> musicasCurtidasList = (List<Map<String, Object>>) dados.get("musicasCurtidas");
        if (musicasCurtidasList != null) {
            List<MusicaCurtidaModel> musicasCurtidas = new ArrayList<>();
            for (Map<String, Object> musicaCurtidaMap : musicasCurtidasList) {
                MusicaCurtidaModel musicaCurtida = new MusicaCurtidaModel();
                musicaCurtida.setNomeAlbum((String) musicaCurtidaMap.get("NomeAlbum"));
                musicaCurtida.setNomeDoArtista((String) musicaCurtidaMap.get("NomeDoArtistas"));
                musicaCurtida.setNomeMusica((String) musicaCurtidaMap.get("NomeMusica"));
                musicaCurtida.setDadosCloneSpotifyModel(this);
                musicasCurtidas.add(musicaCurtida);
            }
            this.setMusicasCurtidas(musicasCurtidas);
            logger.info("musicasCurtidas extraídos: {}", musicasCurtidas);
        }
    }

    public void receberDadosCarrinho(Map<String, Object> dadosCarrinho) {
        List<Map<String, Object>> carrinhoList = (List<Map<String, Object>>) dadosCarrinho.get("playlists");
        if (carrinhoList != null) {
            List<CarrinhoModel> carrinhoPlaylist = new ArrayList<>();
            for (Map<String, Object> carrinhoMap : carrinhoList) {
                CarrinhoModel playlistCarrinho = new CarrinhoModel();
                playlistCarrinho.setNome((String) carrinhoMap.get("nome"));
                playlistCarrinho.setQuantidade((Integer) carrinhoMap.get("quantidade"));
                playlistCarrinho.setValorDaPLaylist((Integer) carrinhoMap.get("valor"));
                playlistCarrinho.setValorTotal((Integer) carrinhoMap.get("valorTotal"));
                playlistCarrinho.setDadosCloneSpotifyModel(this);
                carrinhoPlaylist.add(playlistCarrinho);
            }
            this.setCarrinho(carrinhoPlaylist);
        }
        System.out.println("Dados do Carrinho Playlist" + carrinhoList);

//        Object valorTotalObj = dadosCarrinho.get("valorTotal");
//        if (valorTotalObj != null) {
//            Integer valorTotal = (Integer) valorTotalObj;
//            CarrinhoModel carrinhoValorTotal = new CarrinhoModel();
//            carrinhoValorTotal.setValorTotal(valorTotal);
//            carrinhoValorTotal.setDadosCloneSpotifyModel(this);
//            this.setValorTotal(carrinhoValorTotal);
//            logger.info("Valor Total extraído: {}", valorTotal);
//        }
//
//
//        System.out.println("Dados do Carrinho Valor Total: " + valorTotalObj);
    }

    public void imprimirCarrinho() {
        System.out.println("Carrinho:");
        for (CarrinhoModel item : carrinho) {
            System.out.println("Nome: " + item.getNome());
            System.out.println("Quantidade: " + item.getQuantidade());
            System.out.println("Valor: " + item.getValorDaPLaylist());
            System.out.println("Valor total: "+ item.getValorTotal());
        }
    }


    @Override
    public String toString() {
        return "DadosCloneSpotifyModel{" +
                "id=" + id +
                ", usuario = " + usuario +
                ", topArtistas = " + topArtistas +
                ", playlists = " + playlists +
                ", musicasCurtidas = " + musicasCurtidas +
                ", Carrinho = "+carrinho +
                '}';
    }

}
