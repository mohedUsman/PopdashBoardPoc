package hitachi_genai.popDashBoard.dto;

import hitachi_genai.popDashBoard.enums.*;
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
public class ServiceCategoryBreakDownCost {
    private ServiceCategory serviceCategory;
    private BigDecimal totalCost;
    private BillingCurrency billingCurrency;
    private String providerName;
    private String subAccountId;
    private SubAccountName subAccountName;
    private Date period;
    private BigDecimal overallTotalCost;
    private RegionName regionName;
    private ResourceType resourceType;
    private String chargeDescription;

}
