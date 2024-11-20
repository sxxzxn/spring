package net.fullstack7.springboot.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
@Data

public class PageResponseDTO<E> {
    private int total_count;
    private int page_no;
    private int page_size;
    private int total_page;
    private int page_skip_count;
    private int page_block_size;
    private int page_block_start;
    private int page_block_end;

    private int first_page;
    private int last_page;
    private boolean prev_page_flag;
    private boolean next_page_flag;

    private String[] search_type;
    private String search_word;
    private String search_date1;
    private String search_date2;

    List<E> dtoList;

    public PageResponseDTO() {}

    public PageResponseDTO(PageRequestDTO reqDTO, int total_count, int page_no, int page_size, int page_skip_count, int total_page) {
        this.total_count = total_count;
        this.page_no = page_no;
        this.page_size = page_size;
        this.page_skip_count = reqDTO.getPage_skip_count();
        this.total_page = (this.page_skip_count >0 ? (int)Math.ceil(this.total_count/(double)this.page_size):0);
        this.page_block_size = reqDTO.getPage_block_size();
    }

    public int getTotal_page() {
        return (total_page > 0 ? (int)Math.ceil(total_count/(double)this.page_size) : 1);
    }

    public int getPage_skip_count() {
        return (this.page_no-1)*this.page_size;
    }
    public void setPage_block_start(){
        if(this.page_no % this.page_block_size == 0){
            this.page_block_start = this.page_no - (this.page_block_size - 1);
        }else{
            this.page_block_start = (
                    (int)Math.floor((this.page_no - 1) * this.page_block_size) * this.page_block_size)+1;
        }
        this.page_block_start = this.page_no-1;
    }

    public void setPage_block_end(){
        this.page_block_end = (int)Math.ceil(this.page_no/(double)this.page_block_size)*this.page_block_size;
        this.page_block_end = (this.page_block_end > this.total_page ? this.total_page : this.page_block_end);
    }
}
