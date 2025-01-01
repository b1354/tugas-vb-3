package org.test.tugas.satria.registrasi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Registrasi implements ActionListener {
    JTextField textNim = new JTextField();
    JTextField textNama = new JTextField();
    JTextField textJurusan = new JTextField();

    JButton buttonCari = new JButton("Cari");
    JButton buttonTambah = new JButton("Tambah");
    JButton buttonUbah = new JButton("Ubah");
    JButton buttonHapus = new JButton("Hapus");

    String DB_URL = "jdbc:mysql://localhost:3306/vis3_kamis";
    String USER = "root";
    String PASS = "";

    public Registrasi() {
        JFrame frame = new JFrame();

        JLabel judul = new JLabel("Registrasi 2024");
        JLabel labelNama = new JLabel("Nama");
        JLabel labelNim = new JLabel("NIM");
        JLabel labelJurusan = new JLabel("Jurusan");

        frame.setLayout(null);
        judul.setBounds(170, 20, 100, 20);
        frame.add(judul);

        // NIM
        labelNim.setBounds(45, 60, 40, 20);
        textNim.setBounds(100, 60, 190, 20);
        frame.add(labelNim);
        frame.add(textNim);

        // Nama
        labelNama.setBounds(45, 90, 40, 20);
        textNama.setBounds(100, 90, 260, 20);
        frame.add(labelNama);
        frame.add(textNama);

        // Jurusan
        labelJurusan.setBounds(45, 120, 60, 20);
        textJurusan.setBounds(100, 120, 260, 20);
        frame.add(labelJurusan);
        frame.add(textJurusan);

        // Cari
        buttonCari.setBounds(300, 60, 60, 20);
        buttonCari.addActionListener(this);
        frame.add(buttonCari);

        // Tambah
        buttonTambah.setBounds(100, 160, 80, 20);
        buttonTambah.addActionListener(this);
        frame.add(buttonTambah);

        // Hapus
        buttonHapus.setBounds(190, 160, 80, 20);
        buttonHapus.addActionListener(this);
        frame.add(buttonHapus);

        // Ubah
        buttonUbah.setBounds(280, 160, 80, 20);
        buttonUbah.addActionListener(this);
        frame.add(buttonUbah);

        // Membuat frame
        frame.setSize(410, 410);
        frame.setVisible(true);
    }

    private void clearForm() {
        textNim.setText("");
        textNama.setText("");
        textJurusan.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String nim = textNim.getText();
        String nama = textNama.getText();
        String jurusan = textJurusan.getText();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Statement stmt = conn.createStatement();

            if (event.getSource() == buttonTambah) {
                String sql = "INSERT INTO tm_mahasiswa VALUES ('" + nim + "'" + ", " + "'" + nama + "'" + ", " + "'"
                        + jurusan + "');";
                int updateData = stmt.executeUpdate(sql);
                System.out.println("Terhubung");
                JOptionPane.showMessageDialog(null, "Tambah data berhasil");
                clearForm();

            } else if (event.getSource() == buttonHapus) {
                String sql = "DELETE FROM tm_mahasiswa WHERE nim = '" + nim + "';";
                int deleteData = stmt.executeUpdate(sql);
                System.out.println("Terhubung");
                JOptionPane.showMessageDialog(null, "Hapus data berhasil");
                clearForm();

            } else if (event.getSource() == buttonCari) {
                String sql = "SELECT * FROM tm_mahasiswa WHERE nim = '" + nim + "';";
                ResultSet Data = stmt.executeQuery(sql);
                if (Data.next()) {
                    textNama.setText(Data.getString(2));
                    textJurusan.setText(Data.getString(3));
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
                    clearForm();
                }
                System.out.println("Terhubung");

            } else if (event.getSource() == buttonUbah) {
                String sql = "UPDATE tm_mahasiswa SET nama = '" + nama + "', jurusan = '" + jurusan
                        + "' WHERE nim = '" + nim + "';";
                int updateData = stmt.executeUpdate(sql);
                System.out.println("Terhubung");
                JOptionPane.showMessageDialog(null, "Udate data berhasil");
                clearForm();
            }

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " data gagal");
            e.printStackTrace();
        }
    }
}