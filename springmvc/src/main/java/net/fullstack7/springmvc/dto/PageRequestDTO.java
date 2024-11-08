package net.fullstack7.springmvc.dto;

import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.checkerframework.checker.index.qual.Positive;

import javax.validation.constraints.Min;
import javax.validation.constraints.PositiveOrZero;

@Log4j2
@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDTO {
    @Builder.Default
    @PositiveOrZero
    @Min(value = 0)
    private int total_count = 0;
    @Builder.Default
    @Positive
    @Min(value = 1)
    private int page_no = 1;
    @Builder.Default
    @Positive
    @Min(value = 1)
    private int page_size = 10;
    // 페이징 필수 정보들!

    @Builder.Default
    @Positive
    @Min(value = 1)
    private int total_pages = 1;

    @Builder.Default
    @PositiveOrZero
    @Min(value = 0)
    private int page_skip_count = 0;
    @Builder.Default
    @Positive
    @Min(value = 1)
    private int page_black_size = 10;
    @Builder.Default
    @Positive
    @Min(value = 1)
    private int black_start = 1;
    @Builder.Default
    @Positive
    @Min(value = 1)
    private int black_end = 1;

//    private int first_page;
//    private int last_page;
//    private boolean prev_page_flag;
//    private boolean next_page_flag;

//    @Positive
//    @Min(value = 1)
//    public int getTotal_count() {
//        return total_count;
//    }
    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public int getPage_skip_count() {
        return (this.page_no - 1) * this.page_size;
    }

}
