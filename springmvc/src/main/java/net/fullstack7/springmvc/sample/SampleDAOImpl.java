package net.fullstack7.springmvc.sample;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
@Qualifier("normal")
public class SampleDAOImpl implements SampleDAOIf{
    // 일반게시판
    public SampleDAOImpl () {
        log.info("SampleDAOImpl");
    }


}
