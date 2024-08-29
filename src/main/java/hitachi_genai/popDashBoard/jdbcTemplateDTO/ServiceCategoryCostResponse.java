package hitachi_genai.popDashBoard.jdbcTemplateDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceCategoryCostResponse {
    private String serviceCategory;
    private BigDecimal totalCost;
    //private String billingCurrency;
    //private String providerName;
    private String subAccountId;
    private String subAccountName;
    private Date period;

}
