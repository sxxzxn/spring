package net.fullstack7.springboot.service;

import net.fullstack7.springboot.dto.BoardDTO;
import net.fullstack7.springboot.dto.ConditionRequestDTO;
import net.fullstack7.springboot.dto.ConditionResponseDTO;

import java.util.List;

public interface BoardServiceIf {
    public int regist(BoardDTO boardDTO);
    public BoardDTO view(int idx);
    public int modify(BoardDTO boardDTO);
    public void delete(int idx);
    public ConditionResponseDTO<BoardDTO> list(ConditionRequestDTO conditionDTO);


    

}
