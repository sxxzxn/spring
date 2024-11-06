package net.fullstack7.chap1.controller.login;

import net.fullstack7.chap1.dto.MemberDTO;
import net.fullstack7.chap1.service.LoginService;
import net.fullstack7.chap1.util.CommonUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Member;

@WebServlet(name = "/LoginController", value = "/login/login.do")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CommonUtil cUtil = new CommonUtil();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String saveId = cUtil.getCookiesInfo(req, "saveId");
        String savedId = cUtil.getCookiesInfo(req, "savedId");
        if (saveId.isEmpty()) {
            saveId = req.getParameter("saveId");

        }
        req.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String memberId = req.getParameter("memberId");
        String pwd = req.getParameter("pwd");
        String saveId = req.getParameter("saveId");
        String autoLogin = req.getParameter("autoLogin");

        if (! saveId.trim().isEmpty() && saveId.equals("Y")) {
            cUtil.setCookiesInfo(req, res, "/", 60, "", "saveIdFlag", saveId);
            cUtil.setCookiesInfo(req, res, "/", 60, "", "savedId", memberId);
        } else {
            if (!cUtil.getCookiesInfo(req, "saveIdFlag").isEmpty() || !cUtil.getCookiesInfo(req, "savedId").isEmpty())
                cUtil.setCookiesInfo(req, res, "/", -1442, "", "saveIdFlag", "");
                cUtil.setCookiesInfo(req, res, "/", -1442, "", "savedId", "");
        }

            if(!autoLogin.trim().isEmpty() && autoLogin.equals("Y")) {

            }

        try {
            MemberDTO dto = LoginService.INSTANCE.loginInfo(memberId, pwd);
            if (dto != null) {

                HttpSession session = req.getSession();
                session.setAttribute("memberId", memberId);
                session.setAttribute("memberInfo", dto);
                res.sendRedirect("/");
            } else {
                req.setAttribute("ERROR", "PARAM ERROR");
                req.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(req, res);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}