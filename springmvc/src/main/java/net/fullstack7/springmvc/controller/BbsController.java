package net.fullstack7.springmvc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.fullstack7.springmvc.dto.BbsDTO;
import net.fullstack7.springmvc.service.BbsServiceIf;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
@RequiredArgsConstructor
// bbs
@RequestMapping("/bbs")
public class BbsController {
    private final BbsServiceIf bbsService; // 생성자 주입

//    // /bbs/list.do 호출한것과 같음 위에 bbs 미리 지정
//    @GetMapping("/list.do")
//    public String list(Model model
//            , @RequestParam(defaultValue = "1") int pageNo // 이름 같으면 name 지정 다르면 (name= )
//            , @RequestParam(defaultValue = "10") int pageSize
//            , @RequestParam(defaultValue = "idx") String sortField
//            , @RequestParam(defaultValue = "ASC") String sortOrder
//    ){
//         req.setAttribute
//        model.addAttribute("pageNo", pageNo);
//        model.addAttribute("pageSize", pageSize);
//        model.addAttribute("sortField", sortField);
//        model.addAttribute("sortOrder", sortOrder);
//
//        //@ModelAttribute("dto") BbsDTO bbsDTO 이걸로 하면 걍 바로 dto로...
//        model.addAttribute("bbsList", bbsDTO);
//
//        model.addAttribute("bbsList", bbsService.list());
//        log.info("======================");
//        log.info("list : "+ bbsService.list() );
//        log.info("pageNo: " + pageNo);
//        log.info("pageSize: " + pageSize);
//        log.info("sortField: " + sortField);
//        log.info("sortOrder: " + sortOrder);
//        log.info("======================");
//
//        // jsp 위치 -> servlet-context.xml에 설정
//        return "bbs/list";
//    }


    @GetMapping("/list.do")
    public String list(Model model){
        model.addAttribute("bbsList", bbsService.list());
        return "bbs/list";
    }

//    @GetMapping("/view.do")
//    public String view(
//            @RequestParam int idx
//            , @RequestParam(defaultValue = "1") int pageNo
//            , @RequestParam(defaultValue = "10") int pageSize
//            , @RequestParam(defaultValue = "idx") String sortField
//            , @RequestParam(defaultValue = "ASC") String sortOrder
//    ){
//        log.info("======================");
//        log.info("view");
//        log.info("idx: " + idx);
//        log.info("pageNo: " + pageNo);
//        log.info("pageSize: " + pageSize);
//        log.info("sortField: " + sortField);
//        log.info("sortOrder: " + sortOrder);
//        log.info("======================");
//
//        return "bbs/view";
//    }

    @GetMapping("/view.do")
    public String view(int idx, Model model){
        BbsDTO bbsDTO = bbsService.view(idx);
        model.addAttribute("bbsDTO", bbsDTO);
        return "bbs/view";
    }


    @GetMapping("/regist.do")
    public String regist(){

//        log.info("======================");
//        log.info("regist");
//        log.info("======================");

        return "bbs/regist";
    }

    @PostMapping("/regist.do")
    public String registOk(BbsDTO bbsDTO, Model model){

        bbsService.regist(bbsDTO);
        model.addAttribute("bbsDTO", bbsDTO);

        log.info("======================");
        log.info("registOk");
        log.info("======================");

        return "redirect:/bbs/list.do";
    }

    @GetMapping("/modify.do")
    public String modify(BbsDTO bbsDTO, Model model){
        bbsService.modify(bbsDTO);
        model.addAttribute("bbsDTO", bbsDTO);

        log.info("======================");
        log.info("modify");
        log.info("======================");

        return "bbs/modify";
    }

    @PostMapping("/modify.do")
    public String modifyOk(BbsDTO bbsDTO, Model model){
        bbsService.modify(bbsDTO);
        model.addAttribute("bbsDTO", bbsDTO);


        log.info("======================");
        log.info("modifyOk");
        log.info("======================");

        return "redirect:/bbs/list.do";
    }

}
