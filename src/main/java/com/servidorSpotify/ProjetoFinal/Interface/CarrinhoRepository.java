package com.servidorSpotify.ProjetoFinal.Interface;

import com.servidorSpotify.ProjetoFinal.Model.CarrinhoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoRepository extends JpaRepository<CarrinhoModel, Integer> {
}
