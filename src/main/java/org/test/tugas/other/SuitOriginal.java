package org.test.tugas.other;

import java.util.Random;

import javax.swing.JOptionPane;

public class SuitOriginal {
    public static void main (String[] args) {
        String anda = JOptionPane.showInputDialog("input nama");
        boolean flag = true;
        String hasil = "";
        int jmlhGame = 0;
        int jmlhMenang = 0;
        int seri = 0;
        int java = 0;
        int salahInput = 0;
        
        while (flag) {
            hasil = mainGame(anda);

            if (hasil.equals(anda+" menang")) {
                jmlhMenang += 1;
                System.out.println("menang");
            } else if (hasil.equals("seri")) {
                seri +=1;
                System.out.println("seri");
            } else if (hasil.equals("java menang")) {
                java +=1;
                System.out.println("kalah");
            } else if (hasil.equals("Salah Input")) {
                salahInput +=1;
                System.out.println("salah Input");
            }
            
            jmlhGame += 1;
            int tanya = JOptionPane.showConfirmDialog(null, "Apakah anda bosan?","Game suten", JOptionPane.YES_NO_OPTION);
            
            if (tanya==0) {                
                String messageResult = "Hasil \n\nJumlahGame: "+jmlhGame+"x\n"+"Nama: " + anda + "\nMenang: "+ jmlhMenang + "\nJava: "+ java +"\nseri: "+ seri + "\nSalah Input: " + salahInput;
                JOptionPane.showMessageDialog(null, messageResult);
                flag = false;
            }
        }

    }

    private static String mainGame (String nama) {
        String[] pilih = {"batu", "gunting", "kertas"};
        String opsi = "pilih \n0. batu \n1. gunting \n2. kertas";
        String pemenang;

        String anda = JOptionPane.showInputDialog(opsi);
        int andaInt = Integer.parseInt(anda);
        
        if (andaInt > 2 || andaInt < 0) {
            JOptionPane.showMessageDialog(null, "Pilih nilai 0 s/d 2");
            return "Salah Input";
        }

        Random rd = new Random();
        int java = rd.nextInt(2);

        if (andaInt == 0 && java == 1) {
            pemenang = nama + " menang";
        } else if (andaInt == 1 && java == 2) {
            pemenang = nama + " menang";
        } else if (andaInt == 2 && java == 0) {
            pemenang = nama + " menang";
        } else if (andaInt == java ) {
            pemenang = "seri";
        } else {
            pemenang = "java menang";
        }

        String messageResult = nama + " Memilih: " + pilih[andaInt] + "\nJava Memilih: " + pilih[java] + "\n\n" + pemenang;
        JOptionPane.showMessageDialog(null, messageResult);

        return pemenang;
    }
}
