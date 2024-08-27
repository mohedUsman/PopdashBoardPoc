package hitachi_genai.popDashBoard.DTO;

import hitachi_genai.popDashBoard.enums.BillingCurrency;
import hitachi_genai.popDashBoard.enums.SubAccountName;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubAccountNameCost {


    private BigDecimal totalCost;
    private BillingCurrency billingCurrency;
    private String providerName;
    private String subAccountId;
    private SubAccountName SubAccountName;
    private Date period;
    private BigDecimal overallTotalCost;
}
