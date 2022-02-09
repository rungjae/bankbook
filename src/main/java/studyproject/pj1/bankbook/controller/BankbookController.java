package studyproject.pj1.bankbook.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import studyproject.pj1.bankbook.dto.BankbookDTO;
import studyproject.pj1.bankbook.service.BankbookService;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board")
/**
 * 서비스를 제어하는 클래스
 *
 * @author  Lee Jaeseong
 * @version 1.0
 * @see     None
 */
public class BankbookController {
    private final BankbookService bankbookService;
    /**
     * 입금내역 화면 출력
     *
     * @param mv 모델앤뷰
     * @return 내역의 행 정보 반환
     * @exception None
     * @see  None
     */
    @GetMapping(value = "/deposit")
    public ModelAndView depositPage(ModelAndView mv) {
        log.info("deposit 실행");
        mv.setViewName("deposit");
        return mv;
    }
    /**
     * 출금내역 화면 출력
     *
     * @param mv 모델앤뷰
     * @return 내역의 행 정보 반환
     * @exception None
     * @see  None
     */
    @GetMapping(value = "/withdraw")
    public ModelAndView withdrawPage(ModelAndView mv) {
        log.info("withdraw 실행");
        mv.setViewName("withdraw");
        return mv;
    }
    /**
     * 입/출금 건마다의 상세 내역 화면 출력
     *
     * @param mv 모델앤뷰
     * @return 내역의 행 정보 반환
     * @exception None
     * @see  None
     */
    @GetMapping(value = "/history")
    public ModelAndView historyPage(ModelAndView mv) {
        log.info("history 실행");
        mv.setViewName("history");
        return mv;
    }
}
