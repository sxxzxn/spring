package net.fullstack7.springboot.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;

@Log4j2
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "board")
@Table(name="tbl_board_reply", indexes = {
        @Index(name = "IDX_tbl_board_reply_bbs_Idx",
        columnList = "board_idx"
        )
})
public class BoardReplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int idx;
    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;
    //@Column(nullable = false)
    private int boardIdx ; // 게시글 idx
    private int levelIdx;
    @Column(length = 20, nullable = false)
    private String replyMemberId;
    @Column(length = 100, nullable = false)
    private String replyTitle;
    @Column(length = 1000, nullable = false)
    private String replyContent;
    @Column(nullable = false, columnDefinition = "DATETIME NOT NULL DEFAULT now()")
    private LocalDateTime replyRegDate;
    @Column(nullable = true)
    private LocalDateTime replyModifyDate;
}
