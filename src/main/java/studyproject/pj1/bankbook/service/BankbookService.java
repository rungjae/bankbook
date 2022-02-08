package studyproject.pj1.bankbook.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import studyproject.pj1.bankbook.dto.BankbookDTO;
import studyproject.pj1.bankbook.mapper.BankbookMapper;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
/**
 * 서비스기능을 묶어놓은 클래스
 * 내역보여주기 / 입금 / 출금 서비스
 *
 * @author  Lee Jaeseong
 * @version 1.0
 * @see     None
 */
public class BankbookService {
    private final BankbookMapper bankbookMapper;
    /**
     * BANKBOOK 테이블 내 모든 행 반환
     * 전체 내역 리스트 출력
     * @param None
     * @return 내역의 행 정보 반환
     * @exception None
     * @see  None
     */
    public List<BankbookDTO> allUseList() {
        return bankbookMapper.findUseAll();
    }
    /**
     * 입금 내역 계산 서비스
     * @param   dto 얻고자하는 한건의 내역정보
     * @return  입금 계산을 마친 내역 행을 반환
     * @exception None
     * @see     None
     */
    public List<BankbookDTO> depositUse(BankbookDTO dto){
        log.info("입금내역 계산 실행");
        dto.setDaw("입금");
        int result =  bankbookMapper.addUse(dto);
        String updateResult = "내역등록 실패";
        if(result > 0) {
            updateResult = "내역등록 성공";
        }
        log.info(updateResult);
        /**
         * previousDto 마지막 입력된 행의 정보
         */
        BankbookDTO previousDto = bankbookMapper.findUse(dto.getSeq()-1);
        /**
         * previousBal 마지막에 등록된 잔액
         * inputPrice 현재 입력한 금액
         */
        int previousBal = previousDto.getBalance();
        int inputPrice = dto.getPrice();
        bankbookMapper.upBalance(previousBal+inputPrice, dto.getSeq());
        return bankbookMapper.findUseAll();
    }
    /**
     * 출금 내역 계산 서비스
     * @param   dto 얻고자하는 한건의 내역정보
     * @return  출금 계산을 마친 내역 행을 반환
     * @exception None
     * @see     None
     */
    public List<BankbookDTO> withdrawUse(BankbookDTO dto){
        log.info("출금내역 계산 실행");
        dto.setDaw("출금");
        int result =  bankbookMapper.addUse(dto);
        /**
         * previousDto 마지막 입력된 행의 정보
         */
        BankbookDTO previousDto = bankbookMapper.findUse(dto.getSeq()-1);
        /**
         * previousBal 마지막에 등록된 잔액
         * inputPrice 현재 입력한 금액
         */
        int previousBal = previousDto.getBalance();
        int inputPrice = dto.getPrice();

        if(previousBal < inputPrice) {
            String withdrawResult = "잔액이 부족합니다.";
            log.info(withdrawResult);
        }else{
            bankbookMapper.upBalance(previousBal-inputPrice, dto.getSeq());
            String updateResult = "내역등록 실패";
            if(result > 0) {
                updateResult = "내역등록 성공";
            }
            log.info(updateResult);
        }
        return bankbookMapper.findUseAll();
    }
}
