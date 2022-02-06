package studyproject.pj1.bankbook.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import studyproject.pj1.bankbook.dto.BankbookDTO;

import java.util.List;

@Mapper
public interface BankbookMapper {
    @Select("SELECT * FROM BANKBOOK")
    List<BankbookDTO> findUseAll();
}
