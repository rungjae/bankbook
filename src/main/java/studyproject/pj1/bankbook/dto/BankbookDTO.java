package studyproject.pj1.bankbook.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BankbookDTO {
    private Long seq;
    private String use;
    private String daw;
    private int price;
    private int balance;
    private LocalDateTime paymentTime;
}
