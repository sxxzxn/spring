package net.fullstack7.springboot.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.fullstack7.springboot.domain.Board;
import net.fullstack7.springboot.dto.BoardDTO;
import net.fullstack7.springboot.dto.ConditionRequestDTO;
import net.fullstack7.springboot.dto.ConditionResponseDTO;
import net.fullstack7.springboot.repository.BoardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardServiceIf{
    private final ModelMapper modelMapper;
    private final BoardRepository boardRepository;

    @Override
    public int regist(BoardDTO boardDTO) {
        Board board = modelMapper.map(boardDTO, Board.class);
        return boardRepository.save(board).getIdx();
    }

    @Override
    public BoardDTO view(int idx) {
        Optional<Board> result = boardRepository.findById(idx); // 조회해왔을때 널일경우 오류처리해줌
        Board board = result.orElse(null);
        BoardDTO dto = modelMapper.map(board, BoardDTO.class);
        return dto;
    }

    @Override
    public int modify(BoardDTO boardDTO) {
        Optional<Board> result = boardRepository.findById(boardDTO.getIdx());
        Board board = result.orElse(null);
        board.modify(boardDTO.getMemberId(), boardDTO.getTitle(), boardDTO.getContent(),boardDTO.getDisplayDate());
        return boardRepository.save(board).getIdx();
    }

    @Override
    public void delete(int idx) {
        boardRepository.deleteById(idx);
    }

    @Override
    public ConditionResponseDTO<BoardDTO> list(ConditionRequestDTO conditionDTO) {
        String[] search_type = conditionDTO.getSearch_type();
        String search_word = conditionDTO.getSearch_word();
        Pageable pageable = conditionDTO.getPageable("idx");
        Page<Board> result = boardRepository.search2(pageable, search_type, search_word);
        List<BoardDTO> dtoList = result.getContent().stream().map(board -> modelMapper.map(board, BoardDTO.class)).toList();

        return ConditionResponseDTO.<BoardDTO>withAll()
                .conditionRequestDTO(conditionDTO)
                .total_count((int)result.getTotalElements())
                .dtoList(dtoList)
                .build();
    }
}
