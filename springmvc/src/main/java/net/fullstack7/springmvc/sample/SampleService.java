package net.fullstack7.springmvc.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service // 서비스용
public class SampleService {
    @Autowired
    @Qualifier("normal") // 여기서 지정해주면 정상 실행 가능함
    private SampleDAOIf sampleDAOIf;

}
