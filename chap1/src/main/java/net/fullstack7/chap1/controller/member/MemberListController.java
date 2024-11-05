package net.fullstack7.chap1.controller.member;

import net.fullstack7.chap1.dto.MemberDTO;
import net.fullstack7.chap1.service.MemberService;
import net.fullstack7.chap1.util.CommonDateUtil;
import net.fullstack7.chap1.util.CommonUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Member;
import java.util.List;

@WebServlet(name = "MemberListController", value = "/member/list.do")
public class MemberListController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MemberService memberService = MemberService.INSTANCE;
    private CommonUtil cUtil = new CommonUtil();
    private CommonDateUtil dUtil = new CommonDateUtil();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int pageNo = cUtil.getStringToInt(req.getParameter("pageNo"), 1);
        int pageSize = cUtil.getStringToInt(req.getParameter("pageSize"), 1);
        int pageBlockSize = 10;
        int totalCnt = 0;
        try {
            totalCnt = memberService.totalCount();
            List<MemberDTO> dtoList = memberService.list();
            req.setAttribute("mList", dtoList);
            req.setAttribute("pageNo", pageNo);
            req.setAttribute("pageSize", pageSize);
            req.setAttribute("pageBlockSize", pageBlockSize);
            req.setAttribute("totalCnt", totalCnt);
            req.setAttribute("dUtil", dUtil);
            req.getRequestDispatcher("/WEB-INF/views/member/list.jsp").forward(req, res);
        }catch (Exception e) {
            req.setAttribute("errorMsg", e.getMessage());
            req.setAttribute("errorNo", 500);
            e.printStackTrace();
            throw new ServletException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
}
