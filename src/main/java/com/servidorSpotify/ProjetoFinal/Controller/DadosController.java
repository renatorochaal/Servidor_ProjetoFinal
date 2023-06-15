package com.servidorSpotify.ProjetoFinal.Controller;

import com.servidorSpotify.ProjetoFinal.Interface.DadosCloneSpotifyRepository;
import com.servidorSpotify.ProjetoFinal.Model.DadosCloneSpotifyModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DadosController {
    @Autowired
    private DadosCloneSpotifyRepository dadosRepository;

    @GetMapping("/dados")
    public String exibirDados(Model model) {
        List<DadosCloneSpotifyModel> dadosList = dadosRepository.findAll();
        System.out.println("Todos os Dados" + dadosList);
        model.addAttribute("dadosList", dadosList);
        return "dados";
    }

    @GetMapping("/gerar-pdf")
    public ResponseEntity<byte[]> gerarPDF() throws IOException, JRException {
        List<DadosCloneSpotifyModel> dadosList = dadosRepository.findAll();

        // Cria os parâmetros do relatório
        Map<String, Object> parameters = new HashMap<>();
        if (!dadosList.isEmpty()) {
            DadosCloneSpotifyModel dados = dadosList.get(0);
            parameters.put("idSpotifyUsuario", dados.getUsuario().getIdSpotifyUsuario());
            parameters.put("imagemUrlUsuario", dados.getUsuario().getImagemUrlUsuario());
            parameters.put("nomeUsuario", dados.getUsuario().getNomeUsuario());
            parameters.put("topArtistas", dados.getTopArtistas());
            parameters.put("playlists", dados.getPlaylists());
            parameters.put("musicasCurtidas", dados.getMusicasCurtidas());
        }

        // Carrega o arquivo JRXML do relatório
        JasperReport report = JasperCompileManager.compileReport("src/main/resources/static/relatorio_usuario.jrxml");

        // Cria o JasperPrint para o relatório
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(Collections.singletonList(parameters));
        JasperPrint print = JasperFillManager.fillReport(report, parameters, dataSource);

        // Exporta o relatório para PDF
        byte[] pdfBytes = JasperExportManager.exportReportToPdf(print);

        // Configura a resposta HTTP
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "relatorio_usuario.pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

}
