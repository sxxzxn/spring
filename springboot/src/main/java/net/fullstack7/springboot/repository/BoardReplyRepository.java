package net.fullstack7.springboot.repository;

import net.fullstack7.springboot.domain.BoardReplyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BoardReplyRepository extends JpaRepository<BoardReplyEntity, Long> {

    @Query("SELECT r FROM BoardReplyEntity r WHERE r.board.idx= :board_idx")
    Page<BoardReplyEntity> listOfBoardReply(@Param("board_idx") Integer board_idx, Pageable pageable);
}
