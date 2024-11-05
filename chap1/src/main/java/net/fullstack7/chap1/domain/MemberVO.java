package net.fullstack7.chap1.domain;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
@Log4j2
public class MemberVO {
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
