package studyproject.pj1.bankbook.mapper;

import org.apache.ibatis.annotations.*;
import studyproject.pj1.bankbook.dto.BankbookDTO;

import java.util.List;

@Mapper
public interface BankbookMapper {
    @Select("SELECT * FROM BANKBOOK")
    List<BankbookDTO> findUseAll();

    @Select("SELECT * FROM BANKBOOK WHERE SEQ = #{seq}")
    BankbookDTO findUse(int seq);

    @Insert("INSERT INTO BANKBOOK(use, price, balance, payment_time) VALUES (#{use}, #{price}, #{balance}, now())")
    int addUse(BankbookDTO dto);

    @Update("UPDATE BANKBOOK SET use = #{use}, price = #{price}, #{balance} WHERE seq = #{seq}")
    int updateUse(BankbookDTO rdto);
}
