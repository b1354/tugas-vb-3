package org.test.tugas;

import java.util.Random;

import javax.swing.JOptionPane;

public class Suit {
    public static void main (String[] args) {
        String[] pilih = {"batu", "gunting", "kertas"};
        String opsi = "pilih \n0. batu \n1. gunting \n2. kertas";
        String pemenang;

        //Memulai Looping
        boolean flag = true;
        while (flag) {
            String anda = JOptionPane.showInputDialog(opsi);
            int andaInt = Integer.parseInt(anda);
            Random rd = new Random();
            int java = rd.nextInt(2);

            if (andaInt == 0 && java == 1) {
                pemenang = "anda menang";
            } else if (andaInt == 1 && java == 2) {
                pemenang = "anda menang";
            } else if (andaInt == 2 && java == 0) {
                pemenang = "anda menang";
            } else if (andaInt == java ) {
                pemenang = "seri";
            } else {
                pemenang = "java menang";
            }

            String messageResult = "Anda Memilih: " + pilih[andaInt] + "\nJava Memilih: " + pilih[java] + "\n\n" + pemenang;
            JOptionPane.showMessageDialog(null, messageResult);

            String bosan = JOptionPane.showInputDialog("Apakah anda bosan? (yes/no)");
            if (bosan.toLowerCase().equals("yes")) {
                flag = false;
                JOptionPane.showMessageDialog(null, "Terima kasih sudah bermain dengan saya");
            }
        }
    }
}
