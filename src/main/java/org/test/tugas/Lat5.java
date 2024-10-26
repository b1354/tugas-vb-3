package org.test.tugas;

public class Lat5 {
    public static void main(String[] args) {
        System.out.println("Latihan 51 Java");
        double alasx = 10;
        double tinggix = 5;
        double luas = hitungLuas(alasx, tinggix);
        System.out.println("Luas segitiga adalah: " + luas);
        System.out.println("Menghitung luas kubus:");
        double sisi = 10;
        System.out.println("Luas Kubus: " + hitungLuasKubus(sisi));
        System.out.println("Menghitung luas lingkaran");
        double jariJari = 5;
        System.out.println("Luas Lingkaran: " + hitungLuasLingkaran(jariJari));
    }
    private static double hitungLuas(double alas, double tinggi) {
        double luas = (0.5 * alas * tinggi);
        return luas;
    }
    static void hitungSegiEmpat(double panjang, double lebar) {
        System.out.println("Luas Segiempat" + (panjang * lebar));
    }
    static double hitungLuasKubus(double sisi) {
        double luas = sisi * sisi;
        return luas;
    }
    static double hitungLuasLingkaran(double jariJari) {
        double luas = 3.14 * (jariJari*jariJari);
        return luas;
    }
}


