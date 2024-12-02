package org.test.tugas.satria;

import java.util.Random;

import javax.swing.JOptionPane;

public class SuitSatria {
    String nama;

    public SuitSatria(String nama) {
        this.nama = nama;
    }

    public void start() {
        main(null);
    }

    public void main (String[] args) {
        boolean flag = true;
        String hasil = "";
        int jmlhGame = 0;
        int jmlhMenang = 0;
        int seri = 0;
        int java = 0;
        int salahInput = 0;
        
        while (flag) {
            hasil = mainGame(this.nama);

            if (hasil.equals(this.nama+" win")) {
                jmlhMenang += 1;
                System.out.println("win");
            } else if (hasil.equals("draw")) {
                seri +=1;
                System.out.println("draw");
            } else if (hasil.equals("java Win")) {
                java +=1;
                System.out.println("loose");
            } else if (hasil.equals("wrong input")) {
                salahInput +=1;
                System.out.println("wrong input");
            }
            
            jmlhGame += 1;
            int tanya = JOptionPane.showConfirmDialog(null, "Are you Bored?","Game suten", JOptionPane.YES_NO_OPTION);
            
            if (tanya==0) {                
                String messageResult = "Result \n\nGame Count: "+jmlhGame+"x\n"+"Name: " + this.nama + "\nWin: "+ jmlhMenang + "\nJava: "+ java +"\nDraw: "+ seri + "\nWrong Input: " + salahInput;
                JOptionPane.showMessageDialog(null, messageResult);
                flag = false;
            }
        }

    }

    private static String mainGame (String nama) {
        String[] pilih = {"rock", "scissors", "paper"};
        String opsi = "Choose \n0. rock \n1. scissors \n2. paper";
        String pemenang;

        String anda = JOptionPane.showInputDialog(opsi);
        int andaInt = Integer.parseInt(anda);
        
        if (andaInt > 2 || andaInt < 0) {
            JOptionPane.showMessageDialog(null, "choose from 0 - 2");
            return "wrong input";
        }

        Random rd = new Random();
        int java = rd.nextInt(2);

        if (andaInt == 0 && java == 1) {
            pemenang = nama + " win";
        } else if (andaInt == 1 && java == 2) {
            pemenang = nama + " win";
        } else if (andaInt == 2 && java == 0) {
            pemenang = nama + " win";
        } else if (andaInt == java ) {
            pemenang = "draw";
        } else {
            pemenang = "java win";
        }

        String messageResult = nama + " Choose: " + pilih[andaInt] + "\nJava Choose: " + pilih[java] + "\n\n" + pemenang;
        JOptionPane.showMessageDialog(null, messageResult);

        return pemenang;
    }
}
