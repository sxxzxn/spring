package net.fullstack7.springmvc.mapper;

import net.fullstack7.springmvc.domain.BbsVO;

import java.util.List;

public interface BbsMapper {
    int totalCount();
    List<BbsVO> list();
    BbsVO view(int idx);
    void regist(BbsVO vo);
    void modify(BbsVO vo);
    void delete(int idx);
    void addReadCnt(int idx);
}
