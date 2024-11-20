package net.fullstack7.springboot.contorller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@Log4j2
@RequestMapping("/ex")
public class Ex1Controller {
        @GetMapping("/ex1")
        public String ex1(Model model
        , HttpServletRequest req
        , HttpServletResponse res){
//            String [] arr = {"AAA", "BBB", "CCC"};
            String msg = req.getParameter("msg") != null ? req.getParameter("msg") : "안녕안녕";
            int age = req.getParameter("age") != null ? Integer.parseInt(req.getParameter("age")) : 0;

            model.addAttribute("msg", msg);
            model.addAttribute("age", age);
            model.addAttribute("list", Arrays.asList("AAA", "BBB", "CCC"));
            return "ex/ex1";
        }
    @GetMapping("/ex2")
    public String ex2(Model model
            , HttpServletRequest req
            , HttpServletResponse res){
//            String [] arr = {"AAA", "BBB", "CCC"};
        String msg = req.getParameter("msg") != null ? req.getParameter("msg") : "안녕안녕";
        int age = req.getParameter("age") != null ? Integer.parseInt(req.getParameter("age")) : 0;

        model.addAttribute("msg", msg);
        model.addAttribute("age", age);
        model.addAttribute("list", Arrays.asList("AAA", "BBB", "CCC"));
        return "ex/ex2";
    }
}
