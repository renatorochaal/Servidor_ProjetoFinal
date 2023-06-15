package com.servidorSpotify.ProjetoFinal.Controller;

import com.servidorSpotify.ProjetoFinal.Interface.DadosCloneSpotifyRepository;
import com.servidorSpotify.ProjetoFinal.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clonespotify")
@CrossOrigin(origins = "http://localhost:4200")
public class CloneSpotifyController {
    private static final Logger logger = LoggerFactory.getLogger(CloneSpotifyController.class);

    @Autowired
    private DadosCloneSpotifyRepository repository;


    @PostMapping("/dados")
    public void receberDados(@RequestBody Map<String, Object> dados) {
        logger.info("Dados recebidos: {}", dados);
        DadosCloneSpotifyModel dadosModel = new DadosCloneSpotifyModel();
        dadosModel.receberDados(dados);
        logger.info("Salvando dados no banco de dados");
        repository.save(dadosModel);
        logger.info("Dados salvos com sucesso");
    }
    @PostMapping("/carrinho")
    public void receberDadosCarrinho(@RequestBody Map<String, Object> dados) {
        logger.info("Dados do Carrinho recebidos: {}", dados);

        // Buscar a instância existente de DadosCloneSpotifyModel no banco de dados
        List<DadosCloneSpotifyModel> dadosModelList = repository.findAll();
        if (!dadosModelList.isEmpty()) {
            DadosCloneSpotifyModel dadosModelCarrinho = dadosModelList.get(0);
            dadosModelCarrinho.receberDadosCarrinho(dados);
            List<CarrinhoModel> carrinhoModels = dadosModelCarrinho.getCarrinho();
            // use a lista carrinhoModels como desejar
            dadosModelCarrinho.imprimirCarrinho();
            logger.info("Salvando dados no banco de dados");
            repository.save(dadosModelCarrinho);
            logger.info("Dados salvos com sucesso");
        } else {
            logger.error("DadosCloneSpotifyModel não encontrado no banco de dados");
            // Tratar o caso em que DadosCloneSpotifyModel não existe no banco de dados
        }
    }


    @GetMapping("/dados")
    public ResponseEntity<DadosCloneSpotifyModel> getDados() {
        List<DadosCloneSpotifyModel> dados = repository.findAll();
        if (!dados.isEmpty()) {
            return ResponseEntity.ok(dados.get(0));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


