package org.test.tugas.registrasi.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            this.connected = true;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Koneksi Gagal");
            System.out.println(e);
            this.connected = false;
        }        
    }

    public Database(String url) {
        try {
            Dotenv envVars = Dotenv.load();
            String user = envVars.get("DB_USER");
            String pass = envVars.get("DB_PASSWORD");

            this.conn = DriverManager.getConnection(url, user, pass);
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

    public int executeUpdateQuery(PreparedStatement ps) throws Exception{
        try {
            int affectedRows = ps.executeUpdate();
            return affectedRows;
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                throw new Exception("data sudah ada");
            }
            return 0;
        }
    }

    public void connectionClose() {
        try {
            this.conn.close();
            System.out.println("Koneksi Ditutup");
            this.connected = false;
        } catch (Exception e) {
            System.out.println("Tidak dapat menutup koneksi");
        }
    }
}
