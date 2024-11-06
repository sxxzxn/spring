package net.fullstack7.chap1.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonUtil {
    public int getStringToInt(String str, int defaultValue) {
        return (StringUtils.isNumeric(str) ? Integer.parseInt(str) : defaultValue);
    }
    public void setCookiesInfo(HttpServletRequest req, HttpServletResponse res, String path, int maxAge, String domain, String cName, String cValue) {
        Cookie cookie = new Cookie(cName, cValue);
        cookie.setPath(path);
        cookie.setMaxAge(maxAge);
        cookie.setDomain(domain != null ? domain : "/");
        res.addCookie(cookie);
    }

    public String getCookiesInfo(HttpServletRequest req, String cName) {
        Cookie[] cookies = req.getCookies(); // 요청 헤더에 있는 모든 쿠키 조회 조회값=이름;;;;
        if(cookies != null) {
            for(Cookie c : cookies) {
                String cookieName = c.getName();
                String cookieValue = c.getValue();
                if(cookieName.equals(cName)) return cookieValue;
            }
        }

        return "";
    }
    public String makeUuid() {
        return makeUuid();
    }


}
