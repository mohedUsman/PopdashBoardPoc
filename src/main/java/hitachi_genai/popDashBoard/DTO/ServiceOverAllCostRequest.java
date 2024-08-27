package hitachi_genai.popDashBoard.DTO;

import hitachi_genai.popDashBoard.enums.BillingCurrency;
import hitachi_genai.popDashBoard.enums.SubAccountName;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiceOverAllCostRequest {

    private Date ChargePeriodStart;
    private Date ChargePeriodEnd;
    private String periodicity;
    private SubAccountName SubAccountName;
    private String infraCategory;
    private List<String> ProviderName;
    private BillingCurrency BillingCurrency;
}
