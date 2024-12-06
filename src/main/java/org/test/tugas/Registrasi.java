package org.test.tugas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Registrasi {
    public Registrasi() {
        JFrame jf = new JFrame();
        jf.setLayout(null);
        JLabel jl_judul = new JLabel("Registrasi");
        jl_judul.setBounds(100, 20, 200, 50);
        jf.add(jl_judul);

        JLabel jl_nim = new JLabel("NIM");
        jl_nim.setBounds(20, 70, 100, 20);
        jf.add(jl_nim);

        JTextField tf_nim = new JTextField();
        tf_nim.setBounds(70, 70, 100, 20);
        jf.add(tf_nim);

        JButton btn_cari = new JButton("Cari");
        btn_cari.setBounds(180, 70, 100, 20);
        jf.add(btn_cari);

        JLabel jl_nama = new JLabel("Nama");
        jl_nama.setBounds(20, 100, 100, 20);
        jf.add(jl_nama);

        JTextField tf_nama = new JTextField();
        tf_nama.setBounds(70, 100, 200, 20);
        jf.add(tf_nama);

        JLabel jl_jurusan = new JLabel("Jurusan");
        jl_jurusan.setBounds(20, 130, 100, 20);
        jf.add(jl_jurusan);

        JTextField tf_jurusan = new JTextField();
        tf_jurusan.setBounds(70, 130, 200, 20);
        jf.add(tf_jurusan);

        JButton btn_tambah = new JButton("Tambah");
        btn_tambah.setBounds(20, 160, 70, 20);
        jf.add(btn_tambah);

        JButton btn_ubah = new JButton("ubah");
        btn_ubah.setBounds(100, 160, 70, 20);
        jf.add(btn_ubah);

        JButton btn_hapus = new JButton("hapus");
        btn_hapus.setBounds(180, 160, 70, 20);
        jf.add(btn_hapus);

        jf.setSize(300, 300);
        jf.setVisible(true);
    }
}
