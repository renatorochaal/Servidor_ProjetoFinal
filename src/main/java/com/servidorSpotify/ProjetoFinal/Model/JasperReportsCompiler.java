package com.servidorSpotify.ProjetoFinal.Model;

import net.sf.jasperreports.engine.JasperCompileManager;

public class JasperReportsCompiler {
    public static void main(String[] args) {
        try {
            // Caminho para o arquivo .jrxml
            String jrxmlFile = "src/main/resources/static/subrelatorio_top_artistas.jrxml";


            // Compilar o arquivo .jrxml e gerar o arquivo .jasper
            JasperCompileManager.compileReportToFile(jrxmlFile);

            System.out.println("Relatório compilado com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao compilar o relatório: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
