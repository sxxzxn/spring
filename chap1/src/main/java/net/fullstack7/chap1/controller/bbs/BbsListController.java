package net.fullstack7.chap1.controller.bbs;

import net.fullstack7.chap1.dto.BbsDTO;
import net.fullstack7.chap1.service.BbsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "/BbsListController", value = "/bbs/list.do")

public class BbsListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<BbsDTO> bbsDTOList = null;
        try {
            bbsDTOList = BbsService.INSTANCE.list();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("list", bbsDTOList);
//
//        System.out.println("=====================================");
//        System.out.println("Bbs" +bbsDTOList);
//        System.out.println("=====================================");
//
        req.getRequestDispatcher("/WEB-INF/views/bbs/list.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
}
