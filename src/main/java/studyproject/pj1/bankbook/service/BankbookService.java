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
    public BankbookDTO fineUse(int seq) {
        return bankbookMapper.findUse(seq);
    }
    public List<BankbookDTO> addUse(BankbookDTO dto){
        //만약 입출금 선택시 입금이면 기존 balance + price 출금일시 balance - price
        int result =  bankbookMapper.addUse(dto);
        String updateResult = "회원 추가 실패";
        if(result > 0) {
            updateResult = "회원 추가 성공";
        }
        log.info(updateResult);
        return bankbookMapper.findUseAll();
    }
}
