package hitachi_genai.popDashBoard.dto;

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
public class ServiceCategoryCost {


//SELECT " +
//          "CASE WHEN :periodicity = 'daily' THEN DATE_TRUNC('day', c.ChargePeriodStart) " +
//          "     WHEN :periodicity = 'monthly' THEN DATE_TRUNC('month', c.ChargePeriodStart) " +
//          "END AS period, " +
//          "c.ServiceCategory, SUM(c.billedCost) AS TotalCost ,c.ProviderName , c.BillingCurrency ,c.SubAccountId , c.SubAccountName "

    private String serviceCategory;
    private BigDecimal totalCost;
    private String billingCurrency;
    private String providerName;
    private String subAccountId;
    private String subAccountName;
    private Date period;
//    private Date ChargePeriodStart;
//    private Date ChargePeriodEnd;

}
