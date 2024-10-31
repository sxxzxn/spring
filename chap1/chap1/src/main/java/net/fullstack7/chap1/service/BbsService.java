package net.fullstack7.chap1.service;

import net.fullstack7.chap1.dto.BbsDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum BbsService {
    INSTANCE;

    public  List<BbsDTO> getList(){
        List<BbsDTO> list = IntStream.range(1, 10).mapToObj(i->{
            BbsDTO dto = new BbsDTO();
            dto.setIdx(i);
            dto.setBbsRefIdx(i);
            dto.setBbsLevel((short) 1);
            dto.setMemberId("user"+i);
            dto.setTitle("테스트 제목 " + i);
            dto.setContent("테스트 내용 " + i);
            dto.setRegDate(LocalDateTime.now());
            return dto;
        }).collect(Collectors.toList());

        System.out.println("=============================");
        System.out.println(list);
        System.out.println("=============================");
        return list;
    }
}
