package com.servidorSpotify.ProjetoFinal.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/projetofinal";
        String username = "root";
        String password = "12345";
        return DriverManager.getConnection(url, username, password);
    }
}
