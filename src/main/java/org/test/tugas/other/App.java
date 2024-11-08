package org.test.tugas.other;

import javax.swing.JOptionPane;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String nama = JOptionPane.showInputDialog("Masukan nama anda");
        Integer umur = Integer.valueOf(JOptionPane.showInputDialog("Masukan umur anda"));
        ShowName.main(nama, umur);

        Integer jmlhLoop = Integer.valueOf(JOptionPane.showInputDialog("Masukan Jumlah Perulangan"));
        Looping.main(jmlhLoop);
    }
}
