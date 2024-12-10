package org.test.tugas.registrasi.config;

import java.sql.Connection;
import java.sql.DriverManager;

import io.github.cdimascio.dotenv.Dotenv;

public class Koneksi {
    public Connection conn;
    public boolean connected;
    
    public Koneksi() {
        try {
            Dotenv envVars = Dotenv.load();

            String url = envVars.get("DB_URL");
            String user = envVars.get("DB_USER");
            String pass = envVars.get("DB_PASSWORD");

            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Koneksi Berhasil");
            this.connected = true;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Koneksi Gagal");
            System.out.println(e);
            this.connected = false;
        }        
    }
}
