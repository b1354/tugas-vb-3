package org.test.tugas.registrasi.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.test.tugas.registrasi.config.Database;
import org.test.tugas.registrasi.model.Mahasiswa;
import org.test.tugas.registrasi.view.components.TextInput;

public class Registrasi implements ActionListener {
    Database koneksi = new Database();
    JFrame jf = new JFrame("Registrasi");
    JLabel jl_judul = new JLabel("Registrasi");
    TextInput tf_nim = new TextInput("nim");
    TextInput tf_nama = new TextInput("nama");
    TextInput tf_jurusan = new TextInput("jurusan");
    JButton btn_cari = new JButton("Cari");
    JButton btn_tambah = new JButton("Tambah");
    JButton btn_ubah = new JButton("ubah");
    JButton btn_hapus = new JButton("hapus");

    public Registrasi() {
        if (!koneksi.connected) {
            String errorMessage = "Terjadi Error,\n Tidak dapat terhubung ke database";
            JOptionPane.showMessageDialog(jf, errorMessage, "Error", 0);
            return;
        }

        tf_nim.setWidth(100);

        btn_cari.addActionListener(this);
        btn_tambah.addActionListener(this);
        btn_ubah.addActionListener(this);
        btn_hapus.addActionListener(this);

        jl_judul.setBounds(125, 10, 150, 50);
        tf_nama.add(jf, 20, 100);
        btn_cari.setBounds(180, 70, 90, 20);
        tf_jurusan.add(jf, 20, 130);
        tf_nim.add(jf, 20, 70);
        btn_tambah.setBounds(20, 160, 70, 20);
        btn_ubah.setBounds(110, 160, 70, 20);
        btn_hapus.setBounds(200, 160, 70, 20);

        jf.add(jl_judul);
        jf.add(btn_cari);
        jf.add(btn_tambah);
        jf.add(btn_ubah);
        jf.add(btn_hapus);

        jf.setLayout(null);
        jf.setResizable(false);
        jf.setSize(300, 300);
        jf.setVisible(true);
    }

    public void clearInput() {
        tf_nim.setTextField("");
        tf_nama.setTextField("");
        tf_jurusan.setTextField("");
    }

    @Override
    public void actionPerformed(ActionEvent args) {
        if (args.getSource() == btn_cari) {
            String NIM = tf_nim.getTextField();
            ResultSet hasil = Mahasiswa.getMahasiswa(koneksi, NIM);
            if (hasil != null) {
                try {
                    hasil.next();
                    tf_nama.setTextField(hasil.getString("nama"));
                    tf_jurusan.setTextField(hasil.getString("jurusan"));
                } catch (Exception e) {
                    if (e.getMessage().contains("Illegal operation on empty result set")) {
                        JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
                    } else {
                        JOptionPane.showMessageDialog(null, "Terjadi kesalahan dalam mengambil data");
                    }
                }
            }

        } else if (args.getSource() == btn_tambah) {
            String NIM = tf_nim.getTextField();
            String Nama = tf_nama.getTextField();
            String Jurusan = tf_jurusan.getTextField();
            if (Mahasiswa.insertMahasiswa(koneksi, NIM, Nama, Jurusan) != 0) {
                JOptionPane.showMessageDialog(null, "data berhasil di inputkan");
            } else {
                JOptionPane.showMessageDialog(null, "terjadi masalah dalam menginput data");
            };
            clearInput();
        } else if (args.getSource() == btn_ubah) {
            String NIM = tf_nim.getTextField();
            String Nama = tf_nama.getTextField();
            String Jurusan = tf_jurusan.getTextField();
            if (Mahasiswa.updateMahasiswa(koneksi, NIM, Nama, Jurusan) != 0) {
                JOptionPane.showMessageDialog(null, "berhasil mengubah data");
            } else {
                JOptionPane.showMessageDialog(null, "gagal mengubah data");
            }
            clearInput();
        } else if (args.getSource() == btn_hapus) {
            String NIM = tf_nim.getTextField();
            if (Mahasiswa.deleteMahasiswa(koneksi, NIM) != 0) {
                JOptionPane.showMessageDialog(null, "berhasil menghapus data");
            } else {
                JOptionPane.showMessageDialog(null, "data tidak ditemukan");
            }
            clearInput();
        }
    }
}
