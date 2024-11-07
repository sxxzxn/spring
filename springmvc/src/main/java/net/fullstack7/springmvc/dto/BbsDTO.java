package net.fullstack7.springmvc.dto;

import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.checkerframework.checker.index.qual.Positive;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

@Log4j2
@Data
@AllArgsConstructor //생성자
@NoArgsConstructor //필드 없는 생성자
@Builder //이거 이용해서 매핑
public class BbsDTO {
    @Positive // 0보다 크고 숫자만들어오도록 (롬복에서 오류 내줌)
    private int idx;
    @Positive
    private int refIdx;
    @Builder.Default // 기본값 지정!
    @PositiveOrZero // 0 허용
    @Min(value = 1)
    private int levelIdx = 1;
    @Builder.Default
    @PositiveOrZero
    @Min(value = 1)
    private int sortOrder = 1;
    @NotBlank //공백 불가
    private String memberId;
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    private String displayDate ;
    private LocalDateTime regDate;
    private LocalDateTime modifyDate;
    @Builder.Default
    @PositiveOrZero
    @Min(value = 0)
    private int readCnt = 0;
    private String filePath;
    private String fileName;
    private String fileExt;
    private int fileSize;
    private String fileCategory;

}
