package net.fullstack7.springmvc.service;

import lombok.extern.log4j.Log4j2;
import net.fullstack7.springmvc.dto.BbsDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/config/root-context.xml")
public class BbsServiceTests {
    @Autowired(required = false)
    private BbsServiceIf service;

//    @Test
//    public void testView() {
//        int idx = 533;
//        BbsDTO dto = service.view(idx);
//        Assertions.assertNotNull(dto);
//        log.info(dto);
//        log.info(idx);
//    }
}
