package studyproject.pj1.bankbook.mapper;

import org.apache.ibatis.annotations.*;
import studyproject.pj1.bankbook.dto.BankbookDTO;

import java.util.List;

@Mapper
public interface BankbookMapper {
    @Select("SELECT * FROM BANKBOOK")
    List<BankbookDTO> findUseAll();

    @Select("SELECT * FROM BANKBOOK WHERE SEQ = #{seq}")
    BankbookDTO findUse(Long seq);

    @Insert("INSERT INTO BANKBOOK(use, daw, price, balance, paymentTime) VALUES (#{use}, #{daw}, #{price}, #{balance}, now())")
    @Options(useGeneratedKeys = true, keyProperty = "seq")
    int addUse(BankbookDTO dto);
    //현재 잔액 업데이트용
    @Update("UPDATE BANKBOOK SET balance = #{balance} WHERE seq = #{seq}")
    int upBalance(int balance, Long seq);
}
