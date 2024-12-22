package org.test.tugas.registrasi;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.test.tugas.registrasi.config.Database;
import org.test.tugas.registrasi.model.Mahasiswa;

import io.github.cdimascio.dotenv.Dotenv;

public class MahasiswaTest {
    private Dotenv envVars = Dotenv.load();
    Database mockdatabase = new Database(envVars.get("TEST_DB_URL"));

    @BeforeAll
    public static void setup() {
        Dotenv envVars = Dotenv.load();
        Database mockdatabase = new Database(envVars.get("TEST_DB_URL"));

        try {
            String query = "INSERT INTO tm_mahasiswa VALUES (?, ?, ?)";
            PreparedStatement ps = mockdatabase.conn.prepareStatement(query);
            ps.setString(1, "00000000001");
            ps.setString(2, "John Doe");
            ps.setString(3, "Computer Science");
            mockdatabase.executeUpdateQuery(ps);   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public static void tearDown() {
        Dotenv envVars = Dotenv.load();
        Database mockdatabase = new Database(envVars.get("TEST_DB_URL"));

        try {
            String query = "DELETE FROM tm_mahasiswa";
            PreparedStatement ps = mockdatabase.conn.prepareStatement(query);
            mockdatabase.executeUpdateQuery(ps);   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsertMahasiswa() throws SQLException {
        String NIM = "00000000010";
        String nama = "John Doe";
        String jurusan = "Computer Science";

        int result = Mahasiswa.insertMahasiswa(mockdatabase, NIM, nama, jurusan);
        assertEquals(1,result);
    }

    @Test
    public void testGetAllMahasiswa() throws SQLException {
        ResultSet result = Mahasiswa.getMahasiswa(mockdatabase);
        assertNotNull(result);
    }

    @Test
    public void testGetUndefinedMahasiswa() throws SQLException {
        String NIM = "10293130193";
        ResultSet result = Mahasiswa.getMahasiswa(mockdatabase, NIM);
        assertFalse(result.next());
    }

    @Test
    public void testGetMahasiswaByNIM() throws SQLException {
        String NIM = "00000000001";

        ResultSet result = Mahasiswa.getMahasiswa(mockdatabase, NIM);
        assertNotNull(result);
    }

    @Test
    public void testDeleteMahasiswa() throws SQLException {
        String NIM = "00000000001";

        int result = Mahasiswa.deleteMahasiswa(mockdatabase, NIM);
        assertEquals(1, result);
    }
}
