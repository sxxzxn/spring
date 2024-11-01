package net.fullstack7.chap1.dao;

import lombok.extern.log4j.Log4j2;
import net.fullstack7.chap1.domain.BbsVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Log4j2
public class DaoTests {
    private BbsDAO dao;
    private BbsVO vo;

    @BeforeEach
    public void setUp() {
        dao = new BbsDAO();

    }
    @Test
    public void testGetTime() throws Exception {
        dao.getTime();
        log.info("dao test : "+dao.getTime());

    }

    @Test
    public void testList() throws Exception {

        List<BbsVO> list = dao.list();
        assertNotNull(list);
        list.forEach(
                vo->{
                    log.info("vo test: "+vo);
                }
        );

    }
    @Test
    public void testRegist() throws Exception {

    }

    @Test
    public void testView()  throws Exception {
        int idx =747;

        vo = dao.view(idx);
        assertNotNull(vo);
        log.info("idx : "+idx);
        log.info("vo test : "+vo);
    }
}
