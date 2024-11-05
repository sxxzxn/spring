package net.fullstack7.chap1.controller.bbs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "/BbsListController", value = "/bbs/list.do")

public class BbsListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        List<BbsDTO> bbsDTOList = BbsService.INSTANCE.getList();
//        req.setAttribute("list", bbsDTOList);
//
//        System.out.println("=====================================");
//        System.out.println("Bbs" +bbsDTOList);
//        System.out.println("=====================================");
//
//        req.getRequestDispatcher("/WEB-INF/views/bbs/list.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
}
