package org.test.tugas.satria;

import javax.swing.JOptionPane;

public class AppSatria {
    public static void main(String[] args) {
        String nama = JOptionPane.showInputDialog("Insert your name: ");
        SuitSatria Game = new SuitSatria(nama);
        Game.start();
    }
}
