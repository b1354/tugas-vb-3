package org.test.uts.utsSatria;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args)  {
        String nama = JOptionPane.showInputDialog("Masukan nama anda");
        Suit permainan = new Suit(nama);
        permainan.start();

        // jika menggunakan overloading
        Suit.start("satria");
    }
}
