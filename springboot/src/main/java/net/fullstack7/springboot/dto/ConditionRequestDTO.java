package net.fullstack7.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConditionRequestDTO {
    private int page_no;
    private int page_size;
    
    private String search_type;
    private String search_word;
}
