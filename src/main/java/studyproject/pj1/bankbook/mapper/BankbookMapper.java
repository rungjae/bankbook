package studyproject.pj1.bankbook.mapper;

import org.apache.ibatis.annotations.*;
import studyproject.pj1.bankbook.dto.BankbookDTO;

import java.util.List;

@Mapper
public interface BankbookMapper {
    /**
     * BANKBOOK 테이블 한 행의 모든 정보 반환
     */
    @Select("SELECT * FROM BANKBOOK")
    List<BankbookDTO> findUseAll();
    /**
     * SEQ 값에 해당하는 행의 모든 정보 반환
     */
    @Select("SELECT * FROM BANKBOOK WHERE SEQ = #{seq}")
    BankbookDTO findUse(Long seq);
    /**
     * BANKBOOK 의 내역 정보들을 추가
     * useGeneratedKeys = true 자동생성된 키값을 가져온다
     * keyProperty = "seq" seq 필드로 키값을 받는다
     */
    @Insert("INSERT INTO BANKBOOK(use, daw, price, balance, paymentTime) VALUES (#{use}, #{daw}, #{price}, #{balance}, now())")
    @Options(useGeneratedKeys = true, keyProperty = "seq")
    int addUse(BankbookDTO dto);
    /**
     * SEQ 값에 해당하는 행의 잔액을 반환
     */
    @Update("UPDATE BANKBOOK SET balance = #{balance} WHERE seq = #{seq}")
    int upBalance(int balance, Long seq);
}
