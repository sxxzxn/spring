package net.fullstack7.chap1.service;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import net.fullstack7.chap1.dao.BbsDAO;
import net.fullstack7.chap1.domain.BbsVO;
import net.fullstack7.chap1.dto.BbsDTO;
import net.fullstack7.chap1.util.MapperUtil;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
public enum BbsService {
    INSTANCE;

//    public  List<BbsDTO> getList(){
//        List<BbsDTO> list = IntStream.range(1, 11).mapToObj(i->{
//            BbsDTO dto = new BbsDTO();
//            dto.setIdx(i);
//            dto.setBbsRefIdx(i);
//            dto.setBbsLevel((short) 1);
//            dto.setMemberId("user"+i);
//            dto.setTitle("테스트 제목 " + i);
//            dto.setContent("테스트 내용 " + i);
//            dto.setRegDate(LocalDateTime.now());
//            return dto;
//        }).collect(Collectors.toList());
//
//        System.out.println("=============================");
//        System.out.println(list);
//        System.out.println("=============================");
//        return list;
//    }

    private BbsDAO bbsDAO;
    private ModelMapper modelMapper;

    BbsService(){
        bbsDAO = new BbsDAO();
        modelMapper = MapperUtil.INSTANCE.getModelMapper();
    }
    public List<BbsDTO> list() throws Exception{

//        매퍼설정
        List<BbsVO> list = bbsDAO.list();
        List<BbsDTO> dtoList = list.stream().map(
                vo -> modelMapper.map(vo, BbsDTO.class)
        ).collect(Collectors.toList());

//        log.info("===============================================");
//        log.info("BbsService::start");
//        log.info("list : "+list);
//        log.info("dtolist : "+dtoList);
//        log.info("BbsService::end");
//        log.info("===============================================");
        return dtoList;
    }
    public int regist(BbsDTO dto) throws Exception{

        return 0;
    }

    public BbsDTO view(int idx) throws Exception{

        return null;
    }

    public int modify(BbsDTO dto) throws Exception{

        return 0;
    }
    public int delete(int idx) throws Exception{

        return 0;
    }

}
