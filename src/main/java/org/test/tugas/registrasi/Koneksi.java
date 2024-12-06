package org.test.tugas.registrasi;

import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {
    Connection conn;
    boolean connected;
    
    public Koneksi() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vis3_kamis", "root","");
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
