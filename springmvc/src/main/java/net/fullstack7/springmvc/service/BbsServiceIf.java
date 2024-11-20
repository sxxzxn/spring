package net.fullstack7.springmvc.service;

import net.fullstack7.springmvc.dto.BbsDTO;
import net.fullstack7.springmvc.dto.PageRequestDTO;
import net.fullstack7.springmvc.dto.PageResponseDTO;

import java.util.List;

public interface BbsServiceIf {
    public int totalCount();
    public List<BbsDTO> list();
    public PageResponseDTO<BbsDTO> listByPage(PageRequestDTO requestDTO);
    public BbsDTO view(int idx);
    void regist(BbsDTO dto);
    void modify(BbsDTO dto);
    void delete(int idx);
    void addReadCnt(int idx);
}
