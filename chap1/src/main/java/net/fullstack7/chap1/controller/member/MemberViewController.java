package net.fullstack7.chap1.controller.member;

import net.fullstack7.chap1.dto.MemberDTO;
import net.fullstack7.chap1.service.MemberService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Member;
import java.net.URLEncoder;

@WebServlet(name = "MemberViewController", value = "/member/view.do")
public class MemberViewController extends HttpServlet {
    private final MemberService memberService = MemberService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String memberId = req.getParameter("memberId");
        String rtnURL = URLEncoder.encode(req.getQueryString(), "UTF-8");

        try{
            MemberDTO dto = memberService.view(memberId);
/*            if(dto == null){
                exit(0);
            }*/
            req.setAttribute("dto", dto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        req.getRequestDispatcher("/WEB-INF/views/member/view.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
}