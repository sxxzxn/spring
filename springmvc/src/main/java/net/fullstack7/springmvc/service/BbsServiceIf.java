package net.fullstack7.springmvc.service;

import net.fullstack7.springmvc.domain.BbsVO;
import net.fullstack7.springmvc.dto.BbsDTO;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

public interface BbsServiceIf {
    public int totalCount();
    public List<BbsDTO> list();
    public BbsDTO view(int idx);
    void regist(BbsDTO dto);
    void modify(BbsDTO dto);
    void delete(int idx);
    void addReadCnt(int idx);
}
