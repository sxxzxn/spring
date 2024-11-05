package net.fullstack7.chap1.dto;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
@Log4j2
public class MemberDTO {
    private int memIdx;
    private String memberId;
    private String name;
    private String pwd;
    private String jumin;
    private String addr1;
    private String addr2;
    private String birthday;
    private String jobCode;
    private int mileage;
    private String memberState;
    private LocalDateTime regDate;
    private LocalDateTime leaveDate;
    private LocalDateTime pwdChangeDate;
    private String uuid;


}
