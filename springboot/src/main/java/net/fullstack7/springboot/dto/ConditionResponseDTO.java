package net.fullstack7.springboot.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
@Data
public class ConditionResponseDTO<E> {
    private int page_no;
    private int page_size;
    private int total_count;
    private int total_page;
    private int page_block_start;
    private int page_block_end;

    private boolean prev_page_flag;
    private boolean next_page_flag;

    private List<E> dtoList;

    private String linkURL;
    private String queryString;

    ConditionResponseDTO() {
    }

    @Builder(builderMethodName = "withAll")
    ConditionResponseDTO(ConditionRequestDTO conditionRequestDTO, int total_count, List<E> dtoList) {
//        this.page_no = conditionRequestDTO.getPage_no();
//        this.page_size = conditionRequestDTO.getPage_size();
//        this.total_count = total_count;
//        this.total_page = (int) Math.ceil(total_count / (double) this.page_size);
//        this.page_block_end = (int)
//                Math.ceil(
//                        this.page_no / (double) conditionRequestDTO.getPage_block_size()
//                ) * conditionRequestDTO.getPage_block_size();
//        this.page_block_end = Math.min(this.page_block_end, this.total_page);
//        this.page_block_start = this.page_block_end - (conditionRequestDTO.getPage_block_size() - 1);
//        this.page_block_start = Math.max(this.page_block_start, 1);
//        this.prev_page_flag = this.page_block_start > 1;
//        this.next_page_flag = this.total_page > this.page_block_end;
//
//        int block_size = conditionRequestDTO.getPage_block_size();
//        int current_block = (int) Math.ceil((double) this.page_no / block_size);
//
//
//        this.dtoList = dtoList;

        this.page_no = conditionRequestDTO.getPage_no();
        this.page_size = conditionRequestDTO.getPage_size();
        this.total_count = total_count;
        this.total_page = (int) Math.ceil(total_count / (double) this.page_size);

        int block_size = conditionRequestDTO.getPage_block_size();
        int current_block = (int) Math.ceil((double) this.page_no / block_size);

        this.page_block_start = (current_block - 1) * block_size + 1;
        this.page_block_end = Math.min(this.page_block_start + block_size - 1, this.total_page);

        this.prev_page_flag = this.page_block_start > 1;
        this.next_page_flag = this.page_block_end < this.total_page;

        this.dtoList = dtoList;

        StringBuffer sb = new StringBuffer();
        sb.append("page_no" + this.page_no + "\n");
        sb.append("&page_size" + this.page_size + "\n");
        if (conditionRequestDTO.getSearch_type() != null && conditionRequestDTO.getSearch_word() != null) {
            sb.append("&search_type" + conditionRequestDTO.getSearch_type() + "\n");
            sb.append("&search_word" + conditionRequestDTO.getSearch_word() + "\n");
        }
        this.queryString = sb.toString();

    }
}



