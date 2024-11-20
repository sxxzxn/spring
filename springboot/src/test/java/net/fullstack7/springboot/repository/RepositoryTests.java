package net.fullstack7.springboot.repository;


import lombok.extern.log4j.Log4j2;
import net.fullstack7.springboot.domain.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.support.DelegatingSmartContextLoader;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class RepositoryTests {
    @Autowired
    private BoardRepository boardRepository;

//    @Test
//    public void testRegist(){
//        IntStream.rangeClosed(1,10).forEach(i->{
//            log.info("==============test 시작================");
//            Board board = Board.builder()
//                    .memberId("user1")
//                    .title("테스트제목"+i)
//                    .content("테스트내용"+i)
//                    .displayDate(
//                            new SimpleDateFormat("yyyy-MM-dd").format(new Date(2024-1900, 10, (i%10==0 ? 1 : i%10)))
//                    )
//                    .build();
////        Board savedBoard = boardRepository.save(board);
////        log.info("saveBoard : {}", savedBoard);
////        log.info("idx : {}", savedBoard.getIdx());
//        });
//        log.info("==============test 끝================");
//    }
//
//    @Test
//    public void testView(){
//        int idx = 1;
//        Optional<Board> result = boardRepository.findById(idx); // 결과가 있으면 넣어주고 아니면 null넣어주기
//        Board board = result.orElse(null);
//        log.info("board : {}",board);
//    }
//
//    @Test
//    public void testModify(){
//        int idx = 11;
//        Optional<Board> result = boardRepository.findById(idx); // 인덱스로 데이터베이스 값 가져오기
//        Board dto = Board.builder()
//                .memberId("user1")
//                .title("테스트제수정확인11")
//                .content("테스트내용수정확인11")
//                .displayDate("2024-12-19")
//                .build();
//        Board board = result.orElse( Board.builder()
//                .memberId("user1")
//                .title("테스트제수정확인11")
//                .content("테스트내용수정확인11")
//                .displayDate("2024-12-19")
//                .build());
//        board.modify(dto.getMemberId(), dto.getTitle(), dto.getContent(), dto.getDisplayDate());
//        boardRepository.save(board);
//        log.info("board : {}",board);
//    }
//    @Test
//    public void testDelete(){
//        int idx = 11;
//        Optional<Board> result = boardRepository.findById(idx);
//        Board board = result.orElse(null);
//        boardRepository.delete(board);
//        log.info("board : {}",board);
//    }
//
//    @Test
//    public void testSelect1(){
//        PageRequest pageable = PageRequest.of(0,10, Sort.by("idx").descending());
//        Page<Board> result = boardRepository.findAll(pageable);
//        List<Board> boards = result.getContent();
//        log.info("result : {}",result);
//        log.info("boards : {}",boards);
//    }

    @Test
    public void testSearch1() {
        PageRequest pageable = PageRequest.of(0, 10, Sort.by("idx").descending());
        boardRepository.search1(pageable);
    }

    @Test
    public void testSearch2() {
        String[]  searchCategory = {"title", "content", "memberId"};
        String searchWord = "1";
        PageRequest pageable = PageRequest.of(0, 10, Sort.by("idx").descending());
        Page<Board> boardList =  boardRepository.search2(pageable,searchCategory,searchWord );
        log.info("========testSearch2 GO=============");
        log.info("total Page {}",boardList.getTotalPages());
        log.info("total size {}",boardList.getSize());
        log.info("page number {}",boardList.getNumber());
        log.info("prev  {}",boardList.hasPrevious());
        log.info("next  {}",boardList.hasNext());
        log.info("boardList  {}",boardList.hasNext());
        boardList.getContent().forEach(board -> {
            log.info(board.toString());
               });
        log.info("========testSearch2 END=============");
    }


}
