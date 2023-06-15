package com.servidorSpotify.ProjetoFinal.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carrinho")
public class CarrinhoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome_da_playlist")
    private String nome;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "valor_da_playlist")
    private int valorDaPLaylist;
    @Column(name = "valor_total")
    private int ValorTotal;

    //getters e setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getValorDaPLaylist() {
        return valorDaPLaylist;
    }

    public void setValorDaPLaylist(int valorDaPLaylist) {
        this.valorDaPLaylist = valorDaPLaylist;
    }

    public int getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(int valorTotal) {
        ValorTotal = valorTotal;
    }

    public DadosCloneSpotifyModel getDadosCloneSpotifyModel() {
        return dadosCloneSpotifyModel;
    }

    public void setDadosCloneSpotifyModel(DadosCloneSpotifyModel dadosCloneSpotifyModel) {
        this.dadosCloneSpotifyModel = dadosCloneSpotifyModel;
    }

    @ManyToOne
    @JoinColumn(name = "dados_clone_spotify_model_id")
    private DadosCloneSpotifyModel dadosCloneSpotifyModel;


    @Override
    public String toString() {
        return "UsuarioModel{" +
                ", nome='" + nome + '\'' +
                ", quantidade ='" + quantidade + '\'' +
                ", valor playlist ='" + valorDaPLaylist + '\'' +
                '}';
    }
}
