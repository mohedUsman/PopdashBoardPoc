package hitachi_genai.popDashBoard.model;


import com.opencsv.bean.CsvBindByName;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FocusExportRepresentation {

//    @CsvBindByName
//    private String AvailabilityZone;

    @CsvBindByName(column="BilledCost")
    private double billedCost;

    @CsvBindByName(column = "BillingAccountId")
    private String billingAccountId;

    @CsvBindByName(column = "BillingAccountName")
    private String BillingAccountName;

    @CsvBindByName(column = "BillingCurrency")
    private String BillingCurrency;

    @CsvBindByName(column = "BillingPeriodEnd")
    private Date BillingPeriodEnd;

    @CsvBindByName(column = "BillingPeriodStart")
    private Date BillingPeriodStart;

    @CsvBindByName(column = "ChargeCategory")
    private String ChargeCategory;

    @CsvBindByName(column = "ChargeClass")
    private String ChargeClass;

    @CsvBindByName(column = "ChargeDescription")
    private String ChargeDescription;

    @CsvBindByName(column = "ChargeFrequency")
    private String ChargeFrequency;

    @CsvBindByName(column = "ChargePeriodEnd")
    private Date ChargePeriodEnd;

    @CsvBindByName(column = "ChargePeriodStart")
    private Date ChargePeriodStart;

    @CsvBindByName(column = "CommitmentDiscountCategory")
    private String CommitmentDiscountCategory;

    @CsvBindByName(column = "CommitmentDiscountID")
    private String CommitmentDiscountId;

    @CsvBindByName(column = "CommitmentDiscountName")
    private String CommitmentDiscountName;

    @CsvBindByName(column = "CommitmentDiscount Status")
    private String CommitmentDiscountStatus;

    @CsvBindByName(column = "CommitmentDiscountType")
    private String CommitmentDiscountType;

    @CsvBindByName(column = "ConsumedQuantity")
    private double ConsumedQuantity;

    @CsvBindByName(column = "ConsumedUnit")
    private String ConsumedUnit;

    @CsvBindByName(column = "ContractedCost")
    private double ContractedCost;

    @CsvBindByName(column = "ContractedUnitPrice")
    private double ContractedUnitPrice;

    @CsvBindByName(column = "EffectiveCost")
    private double EffectiveCost;

    @CsvBindByName(column = "InvoiceIssuer")
    private String InvoiceIssuerName;

    @CsvBindByName(column = "ListCost")
    private double ListCost;

    @CsvBindByName(column = "ListUnitPrice")
    private double ListUnitPrice;

    @CsvBindByName(column = "PricingCategory")
    private String PricingCategory;

    @CsvBindByName(column = "PricingQuantity")
    private double PricingQuantity;

    @CsvBindByName(column = "PricingUnit")
    private String PricingUnit;

    @CsvBindByName(column = "Provider")
    private String ProviderName;

    @CsvBindByName(column = "Publisher")
    private String PublisherName;

    @CsvBindByName(column = "RegionID")
    private String RegionId;

    @CsvBindByName(column = "RegionName")
    private String RegionName;

    @CsvBindByName(column = "ResourceID")
    private String ResourceId;

    @CsvBindByName(column = "ResourceName")
    private String ResourceName;

    @CsvBindByName(column = "ResourceType")
    private String ResourceType;

    @CsvBindByName(column = "ServiceCategory")
    private String ServiceCategory;

    @CsvBindByName(column = "ServiceName")
    private String ServiceName;

    @CsvBindByName(column = "SkuId")
    private String SkuId;

    @CsvBindByName(column = "SubAccountID")
    private String SubAccountId;

    @CsvBindByName(column = "SubAccountName")
    private String SubAccountName;

    @CsvBindByName(column = "Tags")
    private String Tags;
}
