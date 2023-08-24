package learn.labs.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class HikariConnectionPoolTest {

    // Membua kan menutup koneksi database secara otomatis
    @Test
    void testHikariConnectionPool() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/belajar_java_database?serverTimezone=Asia/Jakarta");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("");

        hikariConfig.setMaximumPoolSize(10); // Maximum pool size
        hikariConfig.setMaximumPoolSize(5); // Maximum pool size
        hikariConfig.setIdleTimeout(60_000); // Idle timeout ->
        hikariConfig.setMaxLifetime(10 * 60_000);

        try {
            HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
            Connection connection = hikariDataSource.getConnection();
            connection.close(); // -> Sebenarnya dia tidak menghentikan koneksinya melainkan dia mengembalikan ke Hikari data source nya

            hikariDataSource.close(); // Otomatis menge close semua pool yang ada pada connection pool nya
        } catch (SQLException e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    void testUtil() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
    }
}
