package net.fullstack7.springmvc.mapper;

import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Select;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/config/root-context.xml")
public class TimeMapperTests {
    @Autowired(required = false)
    private TimeMapper timeMapper;
    private TimeMapper2 timeMapper2;

    @Test
    public void testGetTime() {
        log.info(timeMapper.getTime());
    }
    @Test
    public void testGetTime2() {
        log.info(timeMapper2.getTime());
    }
}
