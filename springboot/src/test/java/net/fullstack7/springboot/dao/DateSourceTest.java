package net.fullstack7.springboot.dao;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
@Log4j2
public class DateSourceTest {
    @Autowired //의존성주입자동 3.1이하는 inject?
    private DataSource ds;

//    @Test
//    public void testDateSource() throws SQLException {
//        @Cleanup Connection conn = ds.getConnection();
//        Assertions.assertNotNull(conn);
//        log.info(conn);
//    }
}
