package net.fullstack7.springboot.service;

import lombok.extern.log4j.Log4j2;
import net.fullstack7.springboot.domain.Board;
import net.fullstack7.springboot.dto.BoardDTO;
import net.fullstack7.springboot.dto.ConditionRequestDTO;
import net.fullstack7.springboot.dto.ConditionResponseDTO;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardServiceTests {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BoardServiceIf boardService;

//    @Test
//    public void testRegist() {
//        log.info("==========testRegist GOGO==============");
//        IntStream.rangeClosed(20, 90).forEach(i -> {
//            Board board = Board.builder()
//                    .memberId("user2")
//                    .title("제목"+i)
//                    .content("내용"+i)
//                    .displayDate("2024-11-20")
//                    .build();
//            int rtnResult = boardService.regist(modelMapper.map(board, BoardDTO.class));
//            log.info("regist result {}",rtnResult);
//            log.info("board {}",board);
//        });
//        log.info("==========testRegist END==============");
//    }
//
//    @Test
//    public void testView() {
//        int idx = 1;
//        BoardDTO dto = boardService.view(idx);
//        log.info("view result {}",dto);
//    }
//
//    @Test
//    public void testModify() {
//        int idx = 10;
//        Board board = Board.builder()
//                .idx(idx)
//                .memberId("user2")
//                .title("테스트 22")
//                .content(" 테스트 내요오옹")
//                .displayDate("2024-11-22")
//                .build();
//        log.info("board {}",board);
//    }
//
//
//    @Test
//    public void testDelete() {
//        int idx = 1;
//        boardService.delete(idx);
//        log.info("idx {}",idx);
//
//    }
//
//
//    @Test
//    public void testList() {
//        ConditionRequestDTO conditionDTO = ConditionRequestDTO.builder()
//                                            .page_no(1)
//                                            .page_size(10)
//                                            .page_block_size(10)
//                                            .build();
//        ConditionResponseDTO<BoardDTO> responseDTO = boardService.list(conditionDTO);
//        log.info("conditionDTO {}",conditionDTO);
//        log.info("responseDTO {}",responseDTO);
//    }

}
