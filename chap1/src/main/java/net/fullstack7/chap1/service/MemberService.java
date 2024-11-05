package net.fullstack7.chap1.service;

import net.fullstack7.chap1.dao.MemberDAO;
import net.fullstack7.chap1.domain.MemberVO;
import net.fullstack7.chap1.dto.MemberDTO;
import net.fullstack7.chap1.util.MapperUtil;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public enum MemberService {
    INSTANCE;
    private MemberDAO memberDAO;
    private ModelMapper modelMapper;
    private MemberService() {
        memberDAO = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.getModelMapper();
    }

    public int regist(MemberDTO dto) throws Exception {
        MemberVO vo = modelMapper.map(dto, MemberVO.class);
        int result = memberDAO.regist(vo);
        return result;
    }

    public List<MemberDTO> list() throws Exception {
        List<MemberVO> voList = memberDAO.list();
        List<MemberDTO> dtoList = voList.stream()
                .map(vo->modelMapper.map(vo, MemberDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }

    public MemberDTO view(String memberId) throws Exception {
        MemberDAO memberDAO = new MemberDAO();
        MemberVO vo = memberDAO.view(memberId);
        return modelMapper.map(vo, MemberDTO.class);


    }

    public int modify(MemberDTO dto) throws Exception {
        MemberVO vo = modelMapper.map(dto, MemberVO.class);
        int result = memberDAO.modify(vo);
        return result;
    }

    public int delete (String memberId) throws Exception {
        int result = memberDAO.delete(memberId);
        return result;
    }

    public int totalCount() throws Exception {
        int result = memberDAO.totalCount();
        return result;
    }
}
