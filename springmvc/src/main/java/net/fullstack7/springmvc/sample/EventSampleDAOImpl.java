package net.fullstack7.springmvc.sample;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
@Log4j2
@Repository
//@Primary // 우선순위 지정
@Qualifier("event")
public class EventSampleDAOImpl implements SampleDAOIf{

    public EventSampleDAOImpl() {
        log.info("EventSampleDAOImpl");
    }
}
