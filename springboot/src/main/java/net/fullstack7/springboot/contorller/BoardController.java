package net.fullstack7.springboot.contorller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.fullstack7.springboot.dto.BoardDTO;
import net.fullstack7.springboot.dto.ConditionRequestDTO;
import net.fullstack7.springboot.dto.ConditionResponseDTO;
import net.fullstack7.springboot.service.BoardServiceIf;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardServiceIf boardService;

    @GetMapping("/list")
    public String list(Model model, ConditionRequestDTO requestDTO) {
        ConditionResponseDTO<BoardDTO> responseDTO = boardService.list(requestDTO);
        model.addAttribute("responseDTO", responseDTO);
        model.addAttribute("requestDTO", requestDTO);

        return "board/list";
    }

    @GetMapping("/regist")
    public String regist() {
        return "board/regist";
    }

    @PostMapping("/regist")
    public String regist(BoardDTO boardDTO) {
        boardService.regist(boardDTO);
        return "redirect:/board/list";
    }

    @GetMapping("/view")
    public String view(@RequestParam int idx, Model model) {
        BoardDTO boardDTO = boardService.view(idx);
        model.addAttribute("boardDTO", boardDTO);
        return "board/view";
    }

    @GetMapping("/modify")
    public String modify(@RequestParam int idx, Model model) {
        BoardDTO boardDTO = boardService.view(idx);
        model.addAttribute("boardDTO", boardDTO);
        return "board/modify";
    }
    
    @PostMapping("/modify")
    public String modify(@RequestParam int idx, BoardDTO boardDTO,Model model) {
        int result = boardService.modify(boardDTO);
        if (result > 0) {
//            model.addAttribute("errors", "수정성공");
            return "redirect:/board/view?idx=" + idx;
        }else{
            model.addAttribute("boardDTO", boardDTO);
//            model.addAttribute("errors", "수정실패");
            return "redirect:/board/modify?idx=" + idx;
        }
    }

    @GetMapping("/delete")
   public String delete(@RequestParam int idx) {
        boardService.delete(idx);
        return "redirect:/board/list";
    }

}
