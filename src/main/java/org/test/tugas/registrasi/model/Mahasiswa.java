package org.test.tugas.registrasi.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import org.test.tugas.registrasi.model.validation.*;
import org.test.tugas.registrasi.config.Database;

public class Mahasiswa {
    public static ResultSet getMahasiswa(Database db) {
        try {
            ResultSet hasil = db.getData("SELECT * FROM tm_mahasiswa");

            return hasil;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("tidak dapat mengakses data");
            return null;
        }
    }

    public static ResultSet getMahasiswa(Database db, String NIM) {
        try {
            ResultSet hasil = db.getData("SELECT * FROM tm_mahasiswa WHERE NIM =" + NIM);

            return hasil;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Terjadi Kesalahan dalam menginput data");
            return null;
        }
    }


    public static int insertMahasiswa(Database db, String NIM, String nama, String jurusan) {
        String query = "INSERT INTO tm_mahasiswa VALUES (?,?,?)";
        try {
            ValidasiMahasiswa.validasi(NIM, nama, jurusan);
            PreparedStatement ps = db.conn.prepareStatement(query);
            
            ps.setString(1, NIM);
            ps.setString(2, nama);
            ps.setString(3, jurusan);

            return db.executeUpdateQuery(ps);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("tidak dapat memasukan data");
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    public static int updateMahasiswa(Database db, String NIM, String nama, String jurusan) {
    String query = "UPDATE tm_mahasiswa SET nama = ?, jurusan = ? WHERE NIM = ?";
    try {
        PreparedStatement ps = db.conn.prepareStatement(query);
        ps.setString(1, nama);
        ps.setString(2, jurusan);
        ps.setString(3, NIM);
        return db.executeUpdateQuery(ps);
    } catch (Exception e) {
        System.out.println(e);
        System.out.println("tidak dapat mengupdate data");
        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return 0;
    }
}

    public static int deleteMahasiswa(Database db, String NIM) {
    String query = "DELETE FROM tm_mahasiswa WHERE NIM = ?";
    try {
        PreparedStatement ps = db.conn.prepareStatement(query);
        ps.setString(1, NIM);
        return db.executeUpdateQuery(ps);
    } catch (Exception e) {
        System.out.println(e);
        System.out.println("tidak dapat menghapus data");
        return 0;
    }
}
}
