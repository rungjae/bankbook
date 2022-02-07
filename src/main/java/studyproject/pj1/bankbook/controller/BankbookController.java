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
    //입금 등록 화면
    @GetMapping(value = "/board/deposit")
    public ModelAndView bankbookDeposit(ModelAndView mv) {
        log.info("deposit 실행");
        mv.setViewName("deposit.html");
        return mv;
    }
    //입금 실행
    @PostMapping(value = "/board/depositdo")
    public ModelAndView bankbookDepositDo(ModelAndView mv, BankbookDTO dto) {
        log.info("depositdo 실행");
        mv.addObject("useList", bankbookService.depositUse(dto));
        mv.setViewName("redirect:/board/list");
        return mv;
    }
    //출금 등록 화면
    @GetMapping(value = "/board/withdraw")
    public ModelAndView bankbookWithdraw(ModelAndView mv) {
        log.info("withdraw 실행");
        mv.setViewName("withdraw.html");
        return mv;
    }
    //출금 실행
    @PostMapping(value = "/board/withdrawdo")
    public ModelAndView bankbookWithdrawDo(ModelAndView mv, BankbookDTO dto) {
        log.info("withdrawdo 실행");
        mv.addObject("useList", bankbookService.withdrawUse(dto));
        mv.setViewName("redirect:/board/list");
        return mv;
    }
}
