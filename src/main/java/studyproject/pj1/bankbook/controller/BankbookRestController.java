package studyproject.pj1.bankbook.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import studyproject.pj1.bankbook.dto.BankbookDTO;
import studyproject.pj1.bankbook.service.BankbookService;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board")
public class BankbookRestController {
    private final BankbookService bankbookService;
    /**
     * 입금내역 등록 실행
     *
     * @param mv 모델앤뷰
     * @param dto 얻고자하는 한건의 내역정보
     * @return 내역의 행 정보 반환
     * @exception None
     * @see  None
     */
    @PostMapping(value = "/depositdo")
    public ModelAndView depositDo(ModelAndView mv, BankbookDTO dto) {
        log.info("depositdo 실행");
        mv.addObject("useList", bankbookService.depositUse(dto));
        mv.setViewName("redirect:/board/list");
        return mv;
    }
    /**
     * 출금내역 등록 실행
     *
     * @param mv 모델앤뷰
     * @param dto 얻고자하는 한건의 내역정보
     * @return 내역의 행 정보 반환
     * @exception None
     * @see  None
     */
    @PostMapping(value = "/withdrawdo")
    public ModelAndView withdrawDo(ModelAndView mv, BankbookDTO dto) {
        log.info("withdrawdo 실행");
        mv.addObject("useList", bankbookService.withdrawUse(dto));
        mv.setViewName("redirect:/board/list");
        return mv;
    }
}
