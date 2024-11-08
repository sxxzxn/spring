package net.fullstack7.springmvc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.fullstack7.springmvc.dto.BbsDTO;
import net.fullstack7.springmvc.service.BbsServiceIf;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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
    public String view(@RequestParam int idx, Model model){
        BbsDTO bbsDTO = bbsService.view(idx);
        model.addAttribute("bbsDTO", bbsDTO);
        if (bbsDTO != null) {
            bbsService.addReadCnt(idx);
//            쿠키값 확인해서 하거나, 아이디별로하거나
        }
        return "bbs/view";
    }


    @GetMapping("/regist.do")
    public String registGET(){

//        log.info("======================");
//        log.info("regist");
//        log.info("======================");

        return "bbs/regist";
    }

    //@Valid -> BindingResult
    @PostMapping("/regist.do")
    public String registPOST(@Valid BbsDTO bbsDTO
                            , BindingResult bindingResult //DTO에 세팅한거에 안맞으면 오류 담아주고
                             , RedirectAttributes redirectAttributes
    ){
        if(bindingResult.hasErrors()){
            log.info("hasErrors");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/bbs/regist.do";
        }
        bbsService.regist(bbsDTO);

//        log.info("======================");
//        log.info("registOk");
//        log.info("======================");

        return "redirect:/bbs/list.do";
    }

    @GetMapping("/modify.do")
    public String modifyGET(BbsDTO bbsDTO, @RequestParam int idx, Model model){
        bbsDTO = bbsService.view(idx);
        model.addAttribute("bbsDTO", bbsDTO);
        log.info("======================");
        log.info("modify"+bbsDTO);
        log.info("======================");

        return "bbs/modify";
    }

    @PostMapping("/modify.do")
    public String modifyPOST(@RequestParam int idx
                            , @Valid BbsDTO bbsDTO
                            , BindingResult bindingResult
                            , RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            log.info("hasErrors");
            log.info("idx"+bbsDTO.getIdx());
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/bbs/modify.do?idx="+bbsDTO.getIdx();
        }
        bbsService.modify(bbsDTO);
        log.info("======================");
        log.info("modifyOk");
        log.info("======================");

        return "redirect:/bbs/list.do";
    }

    @PostMapping("/delete.do")
    public String delete(@RequestParam int idx){
        bbsService.delete(idx);
        return "/bbs/list.do";
    }

}
