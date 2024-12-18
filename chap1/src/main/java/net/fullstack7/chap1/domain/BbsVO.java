package net.fullstack7.chap1.domain;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BbsVO {
    private int idx;
    private int bbsRefIdx;
    private short bbsLevel;
    private short sortOrder;
    private String memberId;
    private String title;
    private String content;
    private short readCnt;
    private String fileName;
    private String filePath;
    private String fileType;
    private String fileExt;
    private String fileSize;
    private LocalDateTime modifyDate;
    private LocalDateTime regDate;




}
