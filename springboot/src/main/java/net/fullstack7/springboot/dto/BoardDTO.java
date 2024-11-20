package net.fullstack7.springboot.dto;

import jakarta.persistence.*;
import lombok.*;
import net.fullstack7.springboot.domain.BoardBaseEntity;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoardDTO  {
    private int idx;
    private String memberId;
    private String title;
    private String content;
    private String displayDate;
    private LocalDateTime regDate;
    private LocalDateTime modifyDate;
}




