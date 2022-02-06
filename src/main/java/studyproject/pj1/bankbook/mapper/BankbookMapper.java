package studyproject.pj1.bankbook.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import studyproject.pj1.bankbook.dto.BankbookDTO;

import java.util.List;

@Mapper
public interface BankbookMapper {
    @Select("SELECT * FROM BANKBOOK")
    List<BankbookDTO> findUseAll();

    @Select("SELECT * FROM BANKBOOK WHERE SEQ = #{seq}")
    BankbookDTO findUse(int seq);

    @Insert("INSERT INTO BANKBOOK(use, price, balance, payment_time) VALUES (#{use}, #{price}, #{balance}, #{payment_time})")
    @Options(useGeneratedKeys = true, keyProperty = "seq")
    int addUse(BankbookDTO dto);
}
