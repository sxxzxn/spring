package net.fullstack7.springboot.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;

@Log4j2
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardReplyDTO {
    @PositiveOrZero
    @Min(1)
    private int idx;
    @Builder.Default
    @PositiveOrZero
    @Min(0)
    private int bbsIdx = 0;
    @Builder.Default
    @PositiveOrZero
    @Min(0)
    private int levelIdx= 0;
    @NotNull
    private String replyMemberId;
    @NotNull
    @Size(min=2, max=100)
    private String replyTitle;
    @NotNull
    @Size(min=2, max=1000)
    private String replyContent;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime replyRegDate;
    private LocalDateTime replyModifyDate;

}
