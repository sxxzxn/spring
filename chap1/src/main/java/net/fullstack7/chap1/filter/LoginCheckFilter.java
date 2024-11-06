package net.fullstack7.chap1.filter;

import lombok.extern.log4j.Log4j2;
import net.fullstack7.chap1.util.CommonUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebFilter(urlPatterns = "/bbs/*")
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession();

        CommonUtil cUtil = new CommonUtil();

        // 세션체크
        if(session.getAttribute("memberInfo") != null) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        // 쿠키체크
        if(cUtil.getCookiesInfo(req,"memberInfo") != null) {

            res.sendRedirect(req.getContextPath()+"/login/login.jsp");
        }
    }
}
