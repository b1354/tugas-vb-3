package org.test.tugas.other;

import java.util.Random;

import javax.swing.JOptionPane;

public class SuitSatria {
    public static void main(String[] args) {
    String[] pilih = {"ROCK","SCISSORS","PAPER"};
    String opsi ="CHOSEE \n0. ROCK. \n1.SCISSORS \n2.PAPER";
    String pemenang;
   
    //star the loop

     boolean flag=true;
    while (flag) {
        String you = JOptionPane.showInputDialog(opsi);
        int youint=Integer.parseInt(you);
        Random rd= new Random();
        int java=rd.nextInt(2);
    
        if(youint==0 && java==1 ){
            pemenang="YOU WIN";
        }else if (youint == 1 && java == 2) {
            pemenang="YOU WIN";   
        }else if(youint == 2 && java == 0 ){
            pemenang="YOU WIN";
        }else if (youint  == java){
            pemenang="DRAW";
        }else{
            pemenang="JAVA WIN";
        }

        String msg="YOU CHOOSE : " + pilih[youint] + "\nJAVA CHOOSE : " + pilih [java] +"\n\n" + pemenang;
        JOptionPane.showMessageDialog(null, msg);
         
        String bored=JOptionPane.showInputDialog("ARE YOU BORED?(YES/NO)");
        if(bored.toLowerCase().equals("yes")){
            flag=false;
            JOptionPane.showMessageDialog(null, "THANK YOU FOR PLAYING THIS GAME");
        }
    }

    }
} 

