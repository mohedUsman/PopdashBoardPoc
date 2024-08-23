package hitachi_genai.popDashBoard.dto;

import hitachi_genai.popDashBoard.enums.BillingCurrency;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ServiceCategoryCostRequest {

    private Date ChargePeriodStart;
    private Date ChargePeriodEnd;
    private String periodicity;
    private List<String> SubAccountId;
    private String infraCategory;
    private List<String> ProviderName;
    private BillingCurrency BillingCurrency;
}
