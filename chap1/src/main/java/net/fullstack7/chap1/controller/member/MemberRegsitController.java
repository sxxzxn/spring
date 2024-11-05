package net.fullstack7.chap1.controller.member;

import net.fullstack7.chap1.dto.MemberDTO;
import net.fullstack7.chap1.service.MemberService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MemberRegsitController", value = "/member/regist.do")
public class MemberRegsitController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MemberService memberService = MemberService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/member/regist.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String memberId = req.getParameter("memberId");
        String pwd = req.getParameter("pwd");
        String name = req.getParameter("name");
        String jumin = req.getParameter("jumin");
        String addr1 = req.getParameter("addr1");
        String addr2 = req.getParameter("addr2");
        String birthday = req.getParameter("birthday");
        String jobCode = req.getParameter("jobCode");
        int mileage = Integer.parseInt(req.getParameter("mileage"));
        String memberState = req.getParameter("memberState");

        try{
            MemberDTO dto = MemberDTO.builder()
                    .memberId(memberId)
                    .pwd(pwd)
                    .name(name)
                    .jumin(jumin)
                    .addr1(addr1)
                    .addr2(addr2)
                    .birthday(birthday)
                    .jobCode(jobCode)
                    .mileage(mileage)
                    .memberState(memberState)
                    .build();
            int result = memberService.regist(dto);
            if(result > 0){
                res.sendRedirect("/member/list.do");
            }else{
                req.setAttribute("memberDTO", dto);
                req.setAttribute("result", result);
                req.getRequestDispatcher("/WEB-INF/views/member/regist.jsp").forward(req, res);
            }
        }catch (Exception e){
            req.setAttribute("result", -1);
            req.setAttribute("errorMsg", e.getMessage());
            req.setAttribute("errCode", 500);
            e.printStackTrace();

        }

    }
}
