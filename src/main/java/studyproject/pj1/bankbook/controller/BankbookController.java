package studyproject.pj1.bankbook.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import studyproject.pj1.bankbook.service.BankbookService;

@Controller
@Slf4j
@RequiredArgsConstructor

public class BankbookController {
    private final BankbookService bankbookService;

    //통장 전체 리스트
    @GetMapping(value = "/board/list")
    public ModelAndView bankbookList(ModelAndView mv) {
        log.info("List실행");
        mv.addObject("useList", bankbookService.allUseList());
        mv.setViewName("/board.html");
        return mv;
    }


}
