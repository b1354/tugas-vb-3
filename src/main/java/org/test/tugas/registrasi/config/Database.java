package org.test.tugas.registrasi.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import io.github.cdimascio.dotenv.Dotenv;

public class Database {
    public Connection conn;
    public boolean connected;
    
    public Database() {
        try {
            Dotenv envVars = Dotenv.load();

            String url = envVars.get("DB_URL");
            String user = envVars.get("DB_USER");
            String pass = envVars.get("DB_PASSWORD");

            this.conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Koneksi Berhasil");
            this.connected = true;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Koneksi Gagal");
            System.out.println(e);
            this.connected = false;
        }        
    }

    public ResultSet getData(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public int insertData(PreparedStatement ps) {
        try {
            int affectedRows = ps.executeUpdate();
            return affectedRows;
        } catch (Exception e) {
            // TODO: handle exception
            return 0;
        }
    }
}
