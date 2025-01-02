package org.test.tugas.registrasi;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.test.tugas.registrasi.model.validation.ValidasiMahasiswa;

public class ValidasiMahasiswaTest {
    @Test
    public void testValidasiMahasiswa() throws Exception {
        assertDoesNotThrow(() -> {
            ValidasiMahasiswa.validasi("00000000001", "John Doe", "Teknik Informatika");
        });
    }

    @Test
    public void testValidasiMahasiswaInvalid() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            ValidasiMahasiswa.validasi("00000000001", "John Doe", "");
            ValidasiMahasiswa.validasi("00000000001", "", "");
            ValidasiMahasiswa.validasi("000000000000", "", "");
        });
        assertEquals("Input tidak boleh kosong", exception.getMessage());
    }

    @Test
    public void testValidasiNim() throws Exception {
        assertDoesNotThrow(() -> {
            ValidasiMahasiswa.validasiNim("00000000001");
        });
    }

    @Test
    public void testValidasiNimInvalid() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            ValidasiMahasiswa.validasiNim("000000000000");
            ValidasiMahasiswa.validasiNim("");
            ValidasiMahasiswa.validasiNim("1234567890");
        });
        assertEquals("NIM harus 11 karakter", exception.getMessage());
    }
}
