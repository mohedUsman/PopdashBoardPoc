package hitachi_genai.popDashBoard.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import hitachi_genai.popDashBoard.converters.*;
import hitachi_genai.popDashBoard.enums.*;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "BillingCurrency", length = 8)
    @CsvBindByName(column = "BillingCurrency")
    private BillingCurrency BillingCurrency;

    @Column(name = "BillingPeriodEnd", columnDefinition = "timestamptz")
    @CsvBindByName(column = "BillingPeriodEnd")
    @CsvCustomBindByName(converter = CustomDateConverter.class)
    private Date BillingPeriodEnd;

    @Column(name = "BillingPeriodStart", columnDefinition = "timestamptz")
    @CsvBindByName(column = "BillingPeriodStart")
    @CsvCustomBindByName(converter = CustomDateConverter.class)
    private Date BillingPeriodStart;

    @Enumerated(EnumType.STRING)
    @Column(name = "ChargeCategory", length = 16)
    @CsvBindByName(column = "ChargeCategory")
    private ChargeCategory ChargeCategory;

    @Column(name = "ChargeClass", columnDefinition = "text")
    @CsvBindByName(column = "ChargeClass")
    private String ChargeClass;

    @Column(name = "ChargeDescription", columnDefinition = "text")
    @CsvBindByName(column = "ChargeDescription")
    private String ChargeDescription;

    @Enumerated(EnumType.STRING)
    @Column(name = "ChargeFrequency", columnDefinition = "text")
    @CsvCustomBindByName(column = "ChargeFrequency",converter= ChargeFrequencyConverter.class)
    private ChargeFrequency ChargeFrequency;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "ConsumedUnit", length = 32)
    @CsvCustomBindByName(column = "ConsumedUnit",converter = ConsumedUnitConverter.class)
    private ConsumedUnit ConsumedUnit;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "PricingCategory", length = 32)
    @CsvBindByName(column = "PricingCategory")
    private PricingCategory PricingCategory;

    @Column(name = "PricingQuantity")
    @CsvBindByName(column = "PricingQuantity")
    private double PricingQuantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "PricingUnit", length = 32)
    @CsvCustomBindByName(column = "PricingUnit",converter = PricingUnitConverter.class)
    private PricingUnit PricingUnit;

    @Column(name = "ProviderName", length = 64)
    @CsvBindByName(column = "ProviderName")
    private String ProviderName;

    @Column(name = "PublisherName", length = 64)
    @CsvBindByName(column = "PublisherName")
    private String PublisherName;

    @Enumerated(EnumType.STRING)
    @Column(name = "RegionId", length = 16)
    @CsvBindByName(column = "RegionId")
    private RegionId RegionId;

    @Enumerated(EnumType.STRING)
    @Column(name = "RegionName", length = 16)
    @CsvCustomBindByName(column = "RegionName",converter = RegionNameConverter.class)
    private RegionName RegionName;

    @Column(name = "ResourceId", columnDefinition = "text")
    @CsvBindByName(column = "ResourceID")
    private String ResourceId;

    @Column(name = "ResourceName", length = 88)
    @CsvBindByName(column = "ResourceName")
    private String ResourceName;

    @Enumerated(EnumType.STRING)
    @Column(name = "ResourceType", length = 48)
    @CsvCustomBindByName(column = "ResourceType",converter = ResourceTypeConverter.class)
    private ResourceType ResourceType;

    @Enumerated(EnumType.STRING)
    @Column(name = "ServiceCategory", length = 32)
    @CsvCustomBindByName(column = "ServiceCategory",converter = ServiceCategoryConverter.class)
    private ServiceCategory ServiceCategory;

    @Enumerated(EnumType.STRING)
    @Column(name = "ServiceName", length = 32)
    @CsvCustomBindByName(column = "ServiceName",converter = ServiceNameConverter.class)
    private ServiceName ServiceName;

    @Column(name = "SkuId", length = 40)
    @CsvBindByName(column = "SkuId")
    private String SkuId;

    @Column(name = "SkuPriceId", length = 80)
    @CsvBindByName(column = "SkuPriceId")
    private String SkuPriceId;

    @Column(name = "SubAccountId", length = 80)
    @CsvBindByName(column = "SubAccountId")
    private String SubAccountId;

    @Enumerated(EnumType.STRING)
    @Column(name = "SubAccountName", length = 32)
    @CsvBindByName(column = "SubAccountName")
    private SubAccountName SubAccountName;

    @Column(name = "Tags", length = 800)
    @CsvBindByName(column = "Tags")
    private String Tags;
}