package hitachi_genai.popDashBoard.jdbcTemplateDTO;

import hitachi_genai.popDashBoard.enums.BillingCurrency;

import java.util.Date;
import java.util.List;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceCategoryCostRequests {
    private Date ChargePeriodStart;
    private Date ChargePeriodEnd;
    private String periodicity;
    private List<String> SubAccountId;
    //private String infraCategory;
    private List<String> ProviderName;
    private BillingCurrency BillingCurrency;
}
