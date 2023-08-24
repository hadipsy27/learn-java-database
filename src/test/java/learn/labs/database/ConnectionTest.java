package learn.labs.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {


    @BeforeAll
    static void beforeAll() { // karena ini pada unit test maka buat dalah static method before all bukan hanya static method seperti biasanya
        // Registrasi Driver
        try {
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mysqlDriver);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testConnection() {
        String jdbcurl = "jdbc:mysql://localhost:3306/belajar_java_database?serverTimezone=Asia/Jakarta";
        String username = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(jdbcurl, username, password);
            System.out.println("success to connect database");
        } catch (SQLException e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    void testConnectionClose() {
        String jdbcurl = "jdbc:mysql://localhost:3306/belajar_java_database?serverTimezone=Asia/Jakarta";
        String username = "root";
        String password = "";

        // untuk menutup koneksi database mysql bisa menggunakan try with resouce
        try(Connection connection = DriverManager.getConnection(jdbcurl, username, password)) {
            System.out.println("success to connect database");

            // atau bisa menggunakan method close()
//            connection.close();
            // karena method close() adalah implement dari AutoCloseable, maka bisa di implement di try with resouce
        } catch (SQLException e) {
            Assertions.fail(e.getMessage());
        }
    }
}
