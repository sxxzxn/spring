package net.fullstack7.springboot.service;

import net.fullstack7.springboot.dto.BoardDTO;

public interface BoardServiceIf {
    public int regist(BoardDTO boardDTO);
    public BoardDTO view(int idx);
    public int modify(BoardDTO boardDTO);
    public int delete(int idx);
}
