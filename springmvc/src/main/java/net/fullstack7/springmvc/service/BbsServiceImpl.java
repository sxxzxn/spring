package net.fullstack7.springmvc.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.fullstack7.springmvc.domain.BbsVO;
import net.fullstack7.springmvc.dto.BbsDTO;
import net.fullstack7.springmvc.mapper.BbsMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor // 생성자 파라미터 필요
public class BbsServiceImpl implements BbsServiceIf{
    private final BbsMapper bbsXmlMapper;
//    ModelMapper modelMapper = MapperUtil.INSTANCE.getModelMapper();
    private final ModelMapper modelMapper;

    @Override
    public int totalCount() {


        return 0;
    }

    @Override
    public List<BbsDTO> list() {
//        log.info("===============================");
//        log.info("BbsServiceImpl >> list gogogoo");
        List<BbsVO> volist = bbsXmlMapper.list();
        List<BbsDTO> dtoList = volist.stream()
                .map(vo -> modelMapper.map(vo, BbsDTO.class))
                .collect(Collectors.toList());
//        log.info(dtoList);
//        log.info("volist : " + volist );
//        log.info("BbsServiceImpl >> list end");
//        log.info("===============================");
        return dtoList;
    }

    @Override
    public BbsDTO view(int idx) {
//        log.info("===============================");
//        log.info("BbsServiceImpl >> view gogogoo");
        BbsVO vo = bbsXmlMapper.view(idx);
        BbsDTO dto = modelMapper.map(vo, BbsDTO.class);
//        log.info("vo : " + vo);
//        log.info("BbsServiceImpl >> view end");
//        log.info("===============================");
        return dto;
    }

    @Override
    public void regist(BbsDTO dto) {
        BbsVO vo = modelMapper.map(dto, BbsVO.class);
        bbsXmlMapper.regist(vo);
    }

    @Override
    public void modify(BbsDTO dto) {
        BbsVO vo = modelMapper.map(dto, BbsVO.class);
        bbsXmlMapper.modify(vo);

    }

    @Override
    public void delete(int idx) {
        bbsXmlMapper.delete(idx);

    }
}
