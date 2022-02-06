package studyproject.pj1.bankbook.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import studyproject.pj1.bankbook.dto.BankbookDTO;
import studyproject.pj1.bankbook.service.BankbookService;

@Controller
@Slf4j
@RequiredArgsConstructor

public class BankbookController {
    private final BankbookService bankbookService;
    //통장 전체 리스트 화면
    @GetMapping(value = "/board/list")
    public ModelAndView bankbookList(ModelAndView mv) {
        log.info("List실행");
        mv.addObject("useList", bankbookService.allUseList());
        mv.setViewName("board.html");
        return mv;
    }
    //내역 등록 화면
    @GetMapping(value = "/board/register")
    public ModelAndView bankbookRegister(ModelAndView mv) {
        log.info("register 실행");
        mv.setViewName("register.html");
        return mv;
    }
    //내역 등록 실행
    @PostMapping(value = "/board/insert")
    public ModelAndView bankbookInsert(ModelAndView mv, BankbookDTO dto) {
        log.info("Insert 실행");
        mv.addObject("useList", bankbookService.addUse(dto));
        mv.setViewName("redirect:/board/list");
        return mv;
    }

//    @GetMapping(value = "/board/register")
//    public ModelAndView bankbookRegister(ModelAndView mv, int seq) {
//        log.info("register 실행");
//        mv.addObject("use", bankbookService.fineUse(seq));
//        mv.setViewName("/register.html");
//        return mv;
//    }

}
