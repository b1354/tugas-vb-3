package org.test.tugas.registrasi.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.test.tugas.registrasi.config.Database;

public class Mahasiswa {
    public static void getMahasiswa(Database koneksi) {
        try {
            ResultSet hasil = koneksi.getData("SELECT * FROM tm_mahasiswa");

            while(hasil.next()) {
                System.out.println("NIM: " + hasil.getString("NIM"));
                System.out.println("Nama: " + hasil.getString("nama"));
                System.out.println("------------");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("tidak dapat mengakses data");
        }
    }

    public static void getMahasiswa(Database koneksi, String NIM) {
        try {
            ResultSet hasil = koneksi.getData("SELECT * FROM tm_mahasiswa WHERE NIM =" + NIM);

            while(hasil.next()) {
                System.out.println("NIM: " + hasil.getString("NIM"));
                System.out.println("Nama: " + hasil.getString("nama"));
                System.out.println("------------");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("tidak dapat mengakses data");
        }
    }


    public static void insertMahasiswa(Database koneksi, String NIM, String nama, String jurusan) {
        String query = "INSERT INTO tm_mahasiswa VALUES (?,?,?)";
        try {
            PreparedStatement ps = koneksi.conn.prepareStatement(query);
            
            ps.setString(1, NIM);
            ps.setString(2, nama);
            ps.setString(3, jurusan);

            koneksi.insertData(ps);
            System.out.println("berhasil memasukan data");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("tidak dapat memasukan data");
        }
    }
}
