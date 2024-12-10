package org.test.tugas.registrasi;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.test.tugas.registrasi.components.TextInput;
import org.test.tugas.registrasi.config.Koneksi;

public class Registrasi {
    Koneksi koneksi = new Koneksi();
    JFrame jf = new JFrame("Registrasi");
    
    public Registrasi() {
        jf.setLayout(null);
        jf.setResizable(false);;

        if (!koneksi.connected) {
            String errorMessage = "Terjadi Error,\n Tidak dapat terhubung ke database";
            JOptionPane.showMessageDialog(jf, errorMessage, "Error", 0);
            return;
        }
        
        JLabel jl_judul = new JLabel("Registrasi");
        TextInput tf_nim = new TextInput("nim");
        TextInput tf_nama = new TextInput("nama");
        TextInput tf_jurusan = new TextInput("jurusan");

        JButton btn_cari = new JButton("Cari");
        JButton btn_tambah = new JButton("Tambah");
        JButton btn_ubah = new JButton("ubah");
        JButton btn_hapus = new JButton("hapus");

        tf_nim.setWidth(100);

        jl_judul.setBounds(125, 10, 150, 50);
        btn_cari.setBounds(180, 70, 90, 20);
        btn_tambah.setBounds(20, 160, 70, 20);
        btn_ubah.setBounds(110, 160, 70, 20);
        btn_hapus.setBounds(200, 160, 70, 20);

        tf_nama.add(jf, 20, 100);
        tf_jurusan.add(jf, 20, 130);
        tf_nim.add(jf, 20, 70);
        
        jf.add(jl_judul);
        jf.add(btn_cari);
        jf.add(btn_tambah);
        jf.add(btn_ubah);
        jf.add(btn_hapus);

        jf.setSize(300, 300);
        jf.setVisible(true);
    }
}
