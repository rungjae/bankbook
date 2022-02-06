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
    public List<BankbookDTO> allUseList() {
        return bankbookMapper.findUseAll();
    }
}
