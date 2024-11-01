package net.fullstack7.chap1.dao;

import lombok.extern.log4j.Log4j2;
import net.fullstack7.chap1.dto.BbsDTO;
import net.fullstack7.chap1.service.BbsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Log4j2
public class BbsServiecTests {
    private BbsService bbsService;

    @BeforeEach
    public void setUp() throws Exception {
        bbsService = BbsService.INSTANCE;
    }


        @Test
        public void testList() throws Exception{
        List<BbsDTO> list = bbsService.list();
        assertNotNull(list);
        }
}
