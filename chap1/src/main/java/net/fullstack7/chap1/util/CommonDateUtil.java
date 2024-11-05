package net.fullstack7.chap1.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonDateUtil {
    public CommonDateUtil() {}

    // LoaclDatrTime 타입 => DateTime 문자열 형태로 반환 ( 패턴에 따라, 기본형 : yyyy-MM-dd HH:mm:ss)
    public String localDateTimeToString(LocalDateTime localDateTime, String format) {
        return localDateTime.format(DateTimeFormatter.ofPattern(format));
    }
}
