package net.fullstack7.springboot.contorller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.fullstack7.springboot.dto.BoardReplyDTO;
import org.apache.coyote.Response;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.management.modelmbean.ModelMBeanOperationInfo;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/board/replies")
public class BoardReplyController {

    @Tag(name="REGIST", description = "POST 방식 댓글 등록")
    @PostMapping(value = "/regist", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Integer>>regist(@RequestBody BoardReplyDTO replyDTO) {
        Map<String,Integer> map = Map.of("idx",1);
        return ResponseEntity.ok(map);

    }

    @Tag(name="LIST", description = "댓글 목록")
    @GetMapping(value = "/list")
    public void list(int bbs_idx, Model model) {
        Map<String,Integer> map = Map.of("idx",1);

    }
}
