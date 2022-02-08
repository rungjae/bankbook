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
/**
 * 메인화면 제어하는 클래스
 * 메인화면의 URL처리
 * @author  Lee Jaeseong
 * @version 1.0
 * @see     None
 */
public class MainController {
    private final BankbookService bankbookService;
    /**
     * BANKBOOK 테이블 내 모든 행 반환
     * 전체 내역 리스트 출력
     * @param   mv 모델앤뷰
     * @return  list 모델앤뷰 반환
     * @exception None
     * @see     None
     */
    @GetMapping(value = {"/board/list" ,"", "/"})
    public ModelAndView ListPage(ModelAndView mv) {
        log.info("List실행");
        mv.addObject("useList", bankbookService.allUseList());
        mv.setViewName("board");
        return mv;
    }
}
