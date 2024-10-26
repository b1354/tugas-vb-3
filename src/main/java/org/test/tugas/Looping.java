package org.test.tugas;

public class Looping {
    public static void main(Integer args) {
        System.out.println("=====================");

        for (int i = 0; i <= args; i++) {
            System.out.printf("Perulangan ke-%d\n", i);
        }

        System.out.println("=====================");
    }
}