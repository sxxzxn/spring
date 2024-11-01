package net.fullstack7.chap1.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Log4j2
public class ConnectTests {
    @Test
    public void testConnect() throws Exception {
        log.info("====================================");
        log.info("testConnect >> testConnect START");

        //1. 드라이버 설정
        //2. 커넥션 URL 설정
        //3. 아이디/비밀번호
        Class.forName("org.mariadb.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/fullstack7", "root", "1234");
        assertNotNull(conn);
        conn.close();

        log.info("testConnect");
        log.info("testConnect >> testConnect END");
        log.info("====================================");
    }

    @Test
    public void testHikariCP() throws Exception {
        log.info("====================================");
        log.info("testConnect >> testConnect START");

        HikariConfig config = new HikariConfig()

                ;
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/fullstack7");
        config.setUsername("root");
        config.setPassword("1234");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);
        Connection conn = ds.getConnection();
        assertNotNull(conn);
        conn.close();
        log.info("testConnect");
        log.info("testConnect >> testConnect END");
        log.info("=====================================");

    }
}