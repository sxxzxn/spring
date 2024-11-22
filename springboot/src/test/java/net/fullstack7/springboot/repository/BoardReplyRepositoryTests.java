package net.fullstack7.springboot.repository;

import lombok.extern.log4j.Log4j2;
import net.fullstack7.springboot.domain.Board;
import net.fullstack7.springboot.domain.BoardReplyEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@Log4j2
@SpringBootTest
public class BoardReplyRepositoryTests {
    @Autowired
    private BoardReplyRepository boardReplyRepository;

    @Test
    public void testRegist(){
        Board board = Board.builder().idx(10).build();
        IntStream.range(1, 10).forEach(i -> {
            BoardReplyEntity reply = BoardReplyEntity.builder()
                    .board(board)
                    .replyMemberId("user1")
                    .replyTitle("테스트제목 "+ i)
                    .replyContent("테스트 댓글 내용"+i)
                    .replyRegDate(LocalDateTime.now())
                    .build();
            BoardReplyEntity result = boardReplyRepository.save(reply);
            log.info(result);
        });
    }

    @Test
    public void testBoardReplyList(){
        int board_idx=10;
        PageRequest pageAble=PageRequest.of(0,10,
                Sort.by("idx").descending());
        Page<BoardReplyEntity> result=boardReplyRepository.listOfBoardReply(board_idx,pageAble);
        result.getContent().forEach(r->{log.info("reply :{}",r);});
    }


}
