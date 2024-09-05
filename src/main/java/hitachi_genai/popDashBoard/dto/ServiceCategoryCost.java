package hitachi_genai.popDashBoard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
    //private BigDecimal serviceCategoryTotalCost;
    private List<ServicesName> serviceNames;
//    private String billingCurrency;
//    private String providerName;
//    private String subAccountId;
//    private String subAccountName;
//    private Date period;
//    private BigDecimal overallTotalCost;
//    private Date ChargePeriodStart;
//    private Date ChargePeriodEnd;
   // private BigDecimal totalCost = BigDecimal.ZERO;

//    public void addTotalCost(BigDecimal cost){
//        this.totalCost = this.totalCost.add(cost);
//    }

}
