package learn.labs.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionUtil {

    private static final HikariDataSource dataSource;

    // Buat static block
    static {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/belajar_java_database?serverTimezone=Asia/Jakarta");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("");

        hikariConfig.setMaximumPoolSize(10);
        hikariConfig.setMaximumPoolSize(5);
        hikariConfig.setIdleTimeout(60_000);
        hikariConfig.setMaxLifetime(10 * 60_000);

        dataSource = new HikariDataSource(hikariConfig);

    }

    public static HikariDataSource getDataSource(){
        return dataSource;
    }
}
