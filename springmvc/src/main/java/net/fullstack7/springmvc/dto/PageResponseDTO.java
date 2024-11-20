package net.fullstack7.springmvc.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
@Data
public class PageResponseDTO<E> {
    private int total_count;
    private int page_no;
    private int page_size;
    // 페이징 필수 정보들!

    private int total_pages;
    private int page_skip_count;
    private int page_block_size;
    private int block_start;
    private int block_end;

    private int first_page;
    private int last_page;
    private boolean prev_page_flag;
    private boolean next_page_flag;

    // 공지사항, 이벤트 등등 모든 게시판 리스트
    List<E> dtoList;

    public PageResponseDTO() {}

    @Builder(builderMethodName = "withAll") // 전부 매핑해달라는의미
    // 생성자가 생성될때 모두 빌드 매핑되도록
    public PageResponseDTO(PageRequestDTO reqDTO, int total_count, List<E> dtoList) {
        this.total_count = total_count;
        this.page_no = reqDTO.getPage_no();
        this.page_size = reqDTO.getPage_size();
        this.page_skip_count = reqDTO.getPage_skip_count();
        this.total_pages = (this.total_count > 0 ? (int) Math.ceil((this.total_count/(double)this.page_size)) : 1 );
        this.page_block_size = reqDTO.getPage_block_size();

        this.setBlock_start();
        this.setBlock_end();

        this.prev_page_flag = (this.block_start > 1);
        this.next_page_flag = (this.total_pages > this.block_end);
        this.dtoList = dtoList;
    }

    public int getTotal_page() {
        return (this.total_count > 0 ? (int) Math.ceil(this.total_count / (double) this.page_size) : 1);
    }

    public int getPage_skip_count() {
        return (this.page_no - 1) * this.page_size;
    }
    public void setBlock_start() {
        if(this.page_no % this.page_block_size == 0) {
            this.block_start = this.page_no - (this.page_block_size - 1);
        } else {
            this.block_start = ((int)Math.floor(this.page_no / (double)this.page_block_size) * this.page_block_size) + 1;
        }
    }

    public void setBlock_end() {
        this.block_end = (int) Math.ceil(this.page_no /(double) this.page_block_size)*this.page_block_size;
        this.block_end = (this.block_end > this.total_pages ? this.total_pages : this.block_end);
    }



}
