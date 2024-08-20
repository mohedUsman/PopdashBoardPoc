package hitachi_genai.popDashBoard.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.logging.Logger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resource_usage_metrics_data")
@Entity
public class FocusExport {

    private static final Logger logger = Logger.getLogger(FocusExport.class.getName());

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "AvailabilityZone", length = 32)
    private String AvailabilityZone;

    @Column(name = "BilledCost")
    @CsvBindByName(column="BilledCost")
    private double billedCost;

    @Column(name = "BillingAccountId",  columnDefinition = "text")
    @CsvBindByName(column = "BillingAccountId")
    private String billingAccountId;

    @Column(name = "BillingAccountName", length = 32)
    @CsvBindByName(column = "BillingAccountName")
    private String BillingAccountName;

    @Column(name = "BillingCurrency", length = 8)
    @CsvBindByName(column = "BillingCurrency")
    private String BillingCurrency;

    @Column(name = "BillingPeriodEnd", columnDefinition = "timestamptz")
    @CsvBindByName(column = "BillingPeriodEnd")
    @CsvCustomBindByName(converter = CustomDateConverter.class)
    private Date BillingPeriodEnd;

    @Column(name = "BillingPeriodStart", columnDefinition = "timestamptz")
    @CsvBindByName(column = "BillingPeriodStart")
    @CsvCustomBindByName(converter = CustomDateConverter.class)
    private Date BillingPeriodStart;


    @Column(name = "ChargeCategory", length = 16)
    @CsvBindByName(column = "ChargeCategory")
    private String ChargeCategory;

    @Column(name = "ChargeClass", columnDefinition = "text")
    @CsvBindByName(column = "ChargeClass")
    private String ChargeClass;

    @Column(name = "ChargeDescription", columnDefinition = "text")
    @CsvBindByName(column = "ChargeDescription")
    private String ChargeDescription;

    @Column(name = "ChargeFrequency", columnDefinition = "text")
    @CsvBindByName(column = "ChargeFrequency")
    private String ChargeFrequency;

    @Column(name = "ChargePeriodEnd", columnDefinition = "timestamptz")
    @CsvBindByName(column = "ChargePeriodEnd")
    @CsvCustomBindByName(converter = CustomDateConverter.class)
    private Date ChargePeriodEnd;

    @Column(name = "ChargePeriodStart", columnDefinition = "timestamptz")
    @CsvBindByName(column = "ChargePeriodStart")
    @CsvCustomBindByName(converter = CustomDateConverter.class)
    private Date ChargePeriodStart;

    @Column(name = "CommitmentDiscountCategory", columnDefinition = "text")
    @CsvBindByName(column = "CommitmentDiscountCategory")
    private String CommitmentDiscountCategory;

    @Column(name = "CommitmentDiscountId", columnDefinition = "text")
    @CsvBindByName(column = "CommitmentDiscountID")
    private String CommitmentDiscountId;

    @Column(name = "CommitmentDiscountName", columnDefinition = "text")
    @CsvBindByName(column = "CommitmentDiscountName")
    private String CommitmentDiscountName;

    @Column(name = "CommitmentDiscountStatus", columnDefinition = "text")
    @CsvBindByName(column = "CommitmentDiscount Status")
    private String CommitmentDiscountStatus;

    @Column(name = "CommitmentDiscountType", columnDefinition = "text")
    @CsvBindByName(column = "CommitmentDiscountType")
    private String CommitmentDiscountType;

    @Column(name = "ConsumedQuantity")
    @CsvBindByName(column = "ConsumedQuantity")
    private double ConsumedQuantity;

    @Column(name = "ConsumedUnit", length = 32)
    @CsvBindByName(column = "ConsumedUnit")
    private String ConsumedUnit;

    @Column(name = "ContractedCost")
    @CsvBindByName(column = "ContractedCost")
    private double ContractedCost;

    @Column(name = "ContractedUnitPrice")
    @CsvBindByName(column = "ContractedUnitPrice")
    private double ContractedUnitPrice;

    @Column(name = "EffectiveCost")
    @CsvBindByName(column = "EffectiveCost")
    private double EffectiveCost;

    @Column(name = "InvoiceIssuerName", columnDefinition = "text")
    @CsvBindByName(column = "InvoiceIssuer")
    private String InvoiceIssuerName;

    @Column(name = "ListCost")
    @CsvBindByName(column = "ListCost")
    private double ListCost;

    @Column(name = "ListUnitPrice")
    @CsvBindByName(column = "ListUnitPrice")
    private double ListUnitPrice;

    @Column(name = "PricingCategory", length = 32)
    @CsvBindByName(column = "PricingCategory")
    private String PricingCategory;

    @Column(name = "PricingQuantity")
    @CsvBindByName(column = "PricingQuantity")
    private double PricingQuantity;

    @Column(name = "PricingUnit", length = 32)
    @CsvBindByName(column = "PricingUnit")
    private String PricingUnit;

    @Column(name = "ProviderName", length = 64)
    @CsvBindByName(column = "ProviderName")
    private String ProviderName;

    @Column(name = "PublisherName", length = 64)
    @CsvBindByName(column = "PublisherName")
    private String PublisherName;

    @Column(name = "RegionId", length = 16)
    @CsvBindByName(column = "RegionId")
    private String RegionId;

    @Column(name = "RegionName", length = 16)
    @CsvBindByName(column = "RegionName")
    private String RegionName;

    @Column(name = "ResourceId", columnDefinition = "text")
    @CsvBindByName(column = "ResourceID")
    private String ResourceId;

    @Column(name = "ResourceName", length = 88)
    @CsvBindByName(column = "ResourceName")
    private String ResourceName;

    @Column(name = "ResourceType", length = 48)
    @CsvBindByName(column = "ResourceType")
    private String ResourceType;

    @Column(name = "ServiceCategory", length = 32)
    @CsvBindByName(column = "ServiceCategory")
    private String ServiceCategory;

    @Column(name = "ServiceName", length = 32)
    @CsvBindByName(column = "ServiceName")
    private String ServiceName;

    @Column(name = "SkuId", length = 40)
    @CsvBindByName(column = "SkuId")
    private String SkuId;

    @Column(name = "SkuPriceId", length = 80)
    @CsvBindByName(column = "SkuPriceId")
    private String SkuPriceId;

    @Column(name = "SubAccountId", length = 80)
    @CsvBindByName(column = "SubAccountId")
    private String SubAccountId;

    @Column(name = "SubAccountName", length = 32)
    @CsvBindByName(column = "SubAccountName")
    private String SubAccountName;

    @Column(name = "Tags", length = 800)
    @CsvBindByName(column = "Tags")
    private String Tags;
}