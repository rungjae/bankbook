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

public class BankbookService {
    private final BankbookMapper bankbookMapper;
    //내역 리스트 보여주기
    public List<BankbookDTO> allUseList() {
        return bankbookMapper.findUseAll();
    }
    public BankbookDTO fineUse(Long seq) {
        return bankbookMapper.findUse(seq);
    }
    public List<BankbookDTO> depositUse(BankbookDTO dto){
        //입금이면 (이전balance) + (현재입력price)
        log.info(String.valueOf(dto.getSeq()));

        int result =  bankbookMapper.addUse(dto);
        String updateResult = "내역등록 실패";
        if(result > 0) {
            updateResult = "내역등록 성공";
        }
        log.info(updateResult);
        log.info("service seq : {}" , dto.getSeq());
        BankbookDTO previousDto = bankbookMapper.findUse(dto.getSeq()-1); //바로이전 입력 한 dto생성
        log.info("result seq2 : {}" , dto.getSeq()-1);
        log.info("previousDto.getBalance() : {}" , previousDto.getBalance());
        log.info("plus : {}" , previousDto.getBalance()+dto.getPrice());
        bankbookMapper.upBalance(previousDto.getBalance()+dto.getPrice(), dto.getSeq()); //이전 잔액 + 현재 입력 금액 = 현재 잔액으로 표시
        return bankbookMapper.findUseAll();
    }
    public List<BankbookDTO> withdrawUse(BankbookDTO dto){
        //출금일시 (이전balance) - (현재입력price)
        log.info(String.valueOf(dto.getSeq()));

        BankbookDTO previousDto = bankbookMapper.findUse(dto.getSeq()-1); //바로이전 입력 한 dto생성
        //잔액보다 많은 금액 출금시
        if(previousDto.getBalance() < dto.getPrice()) {
            String withdrawResult = "잔액이 부족합니다.";
            log.info(withdrawResult);
        }else{
            int result =  bankbookMapper.addUse(dto);
            bankbookMapper.upBalance(previousDto.getBalance()-dto.getPrice(), dto.getSeq()); //이전 잔액 + 현재 입력 금액 = 현재 잔액으로 표시
            String updateResult = "내역등록 실패";
            if(result > 0) {
                updateResult = "내역등록 성공";
            }
            log.info(updateResult);
        }
//        log.info("service seq : {}" , dto.getSeq());
//        log.info("result seq2 : {}" , dto.getSeq()-1);
//        log.info("previousDto.getBalance() : {}" , previousDto.getBalance());
//        log.info("minus : {}" , previousDto.getBalance()-dto.getPrice());
        return bankbookMapper.findUseAll();
    }
}
