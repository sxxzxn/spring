package net.fullstack7.springmvc.domain;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;

@Log4j2
@Getter
@ToString
@AllArgsConstructor //생성자
@NoArgsConstructor //필드 없는 생성자
@Builder //이거 이용해서 매핑
public class BbsVO {
    private int idx;
    private int refIdx;
    private int levelIdx;
    private int sortOrder;
    private String memberId;
    private String title;
    private String content;
    private String displayDate;
    private LocalDateTime regDate;
    private LocalDateTime modifyDate;
    private int readCnt;
    private String filePath;
    private String fileName;
    private String fileExt;
    private int fileSize;
    private String fileCategory;

}
