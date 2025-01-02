package org.test.tugas.registrasi.model.validation;

public class ValidasiMahasiswa {
    public static boolean validasi(String nim, String nama, String jurusan) throws Exception {
        try {
            validasiInput(nim, nama, jurusan);
            validasiNim(nim);
            return true;   
        } catch (Exception e) {
            throw e;
        }
    }

    public static boolean validasiNim(String nim) throws Exception{
        if (nim.length() != 11) {
            throw new Exception("NIM harus 11 karakter");
        }
        return true;
    }

    public static boolean validasiInput(String nim, String nama, String jurusan) throws Exception{
        if (nim.isEmpty() || nama.isEmpty() || jurusan.isEmpty()) {
            throw new Exception("Input tidak boleh kosong");
        }
        return true;
    }
}
