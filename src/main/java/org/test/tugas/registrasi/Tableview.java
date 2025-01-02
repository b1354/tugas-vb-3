package org.test.tugas.registrasi;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Tableview {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Registration Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        String[] columnName = {"NIM", "Nama", "Jurusan"};
        Object[][] tableData = {
            {"12345", "Rizki", "Teknik Informatika"},
            {"67890", "Rahmad", "Teknik Mesin"},
            {"11111", "Rizal", "Teknik Sipil"},
            {"22222", "Rifki", "Teknik Elektro"},
        };

        JTable table = new JTable(tableData, columnName);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        frame.setVisible(true);
    }
}
