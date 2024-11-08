package net.fullstack7.springmvc.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.checkerframework.checker.index.qual.Positive;

import javax.validation.constraints.Min;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Log4j2
@Data
public class PageResponseDTD<E> {
    private int total_count;
    private int page_no;
    private int page_size;
    // 페이징 필수 정보들!

    private int total_pages;
    private int page_skip_count;
    private int page_black_size;
    private int black_start;
    private int black_end;

    private int first_page;
    private int last_page;
    private boolean prev_page_flag;
    private boolean next_page_flag;

    public PageResponseDTD() {}


    public PageResponseDTD(PageRequestDTO reqDTO, int total_count, List<E> list) {
        this.total_count = total_count;
        this.page_no = reqDTO.getPage_no();
        this.page_size = reqDTO.getPage_size();
        this.page_skip_count = reqDTO.getPage_skip_count();
        this.total_pages = (this.total_count > 0 ? (int) Math.ceil((this.total_count/(double)this.page_size)) : 1 );

    }


}
