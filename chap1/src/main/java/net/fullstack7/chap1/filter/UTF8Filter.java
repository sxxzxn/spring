package net.fullstack7.chap1.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Log4j2
@WebFilter("/*")  
public class UTF8Filter implements Filter {

    // 필터 초기화 메서드
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("UTF8Filter 시작");
    }

    // UTF-8 인코딩을 설정하는 필터 메서드
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 요청과 응답에 UTF-8 인코딩을 설정
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        log.info("인코딩완료");

        // 다음 필터 또는 서블릿으로 요청을 전달
        chain.doFilter(request, response);
    }

    // 필터 종료 시 호출되는 메서드
    @Override
    public void destroy() {
        log.info("UTF8Filter 끝!");
    }
}