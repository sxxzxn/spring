package net.fullstack7.springmvc.sample;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;


@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/config/root-context.xml")
public class SampleTests {

    @Autowired // 의존성 자동주입
    private SampleService sampleService;

    @Test
    public void testService() {
        Assertions.assertNotNull(sampleService);
    }

    @Autowired
    private DataSource dateSource;
    // root-context.xml에서 DataSource 찾아서 사용하기
    @Test
    public void testConnection() throws Exception {
        Connection conn = dateSource.getConnection();
        Assertions.assertNotNull(conn);
        conn.close();

    }



}
