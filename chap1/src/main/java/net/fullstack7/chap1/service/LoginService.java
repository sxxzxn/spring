package net.fullstack7.chap1.service;

import lombok.extern.log4j.Log4j2;
import net.fullstack7.chap1.dao.LoginDAO;
import net.fullstack7.chap1.domain.MemberVO;
import net.fullstack7.chap1.dto.MemberDTO;
import org.modelmapper.ModelMapper;

@Log4j2
public enum LoginService {
    INSTANCE;

    private LoginDAO loginDAO;
    private ModelMapper modelMapper;

    LoginService() {
        loginDAO = new LoginDAO();
        modelMapper = new ModelMapper();
    }

    public MemberDTO loginInfo(String memberId, String pwd) throws Exception {
        MemberVO vo = loginDAO.login(memberId, pwd);
        return (vo != null ? modelMapper.map(vo, MemberDTO.class) : null);

    }
}
