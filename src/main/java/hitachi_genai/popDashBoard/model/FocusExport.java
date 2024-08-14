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
@Table(name = "focus_export")
@Entity
public class FocusExport {

    private static final Logger logger = Logger.getLogger(FocusExport.class.getName());

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Availability Zone", length = 800)
    private String AvailabilityZone;

    @Column(name = "Billed Cost")
    @CsvBindByName(column="BilledCost")
    private double billedCost;

    @Column(name = "Billing Account ID", length = 800)
    @CsvBindByName(column = "BillingAccountId")
    private String billingAccountId;

    @Column(name = "Billing Account Name", length = 800)
    @CsvBindByName(column = "BillingAccountName")
    private String BillingAccountName;

    @Column(name = "Billing Currency", length = 800)
    @CsvBindByName(column = "BillingCurrency")
    private String BillingCurrency;

    @Column(name = "Billing Period End", length = 800)
    @CsvBindByName(column = "BillingPeriodEnd")
    @CsvCustomBindByName(converter = CustomDateConverter.class)
    private Date BillingPeriodEnd;

    @Column(name = "Billing Period Start", length = 800)
    @CsvBindByName(column = "BillingPeriodStart")
    @CsvCustomBindByName(converter = CustomDateConverter.class)
    private Date BillingPeriodStart;

    @Column(name = "Charge Category", length = 800)
    @CsvBindByName(column = "ChargeCategory")
    private String ChargeCategory;

    @Column(name = "Charge Class", length = 800)
    @CsvBindByName(column = "ChargeClass")
    private String ChargeClass;

    @Column(name = "Charge Description", length = 800)
    @CsvBindByName(column = "ChargeDescription")
    private String ChargeDescription;

    @Column(name = "Charge Frequency", length = 800)
    @CsvBindByName(column = "ChargeFrequency")
    private String ChargeFrequency;

    @Column(name = "Charge Period End", length = 800)
    @CsvBindByName(column = "ChargePeriodEnd")
    @CsvCustomBindByName(converter = CustomDateConverter.class)
    private Date ChargePeriodEnd;

    @Column(name = "Charge Period Start", length = 800)
    @CsvBindByName(column = "ChargePeriodStart")
    @CsvCustomBindByName(converter = CustomDateConverter.class)
    private Date ChargePeriodStart;

    @Column(name = "Commitment Discount Category", length = 800)
    @CsvBindByName(column = "CommitmentDiscountCategory")
    private String CommitmentDiscountCategory;

    @Column(name = "Commitment Discount ID", length = 800)
    @CsvBindByName(column = "CommitmentDiscountID")
    private String CommitmentDiscountId;

    @Column(name = "Commitment Discount Name", length = 800)
    @CsvBindByName(column = "CommitmentDiscountName")
    private String CommitmentDiscountName;

    @Column(name = "Commitment Discount Status", length = 800)
    @CsvBindByName(column = "CommitmentDiscount Status")
    private String CommitmentDiscountStatus;

    @Column(name = "Commitment Discount Type", length = 800)
    @CsvBindByName(column = "CommitmentDiscountType")
    private String CommitmentDiscountType;

    @Column(name = "Consumed Quantity", length = 800)
    @CsvBindByName(column = "ConsumedQuantity")
    private double ConsumedQuantity;

    @Column(name = "Consumed Unit", length = 800)
    @CsvBindByName(column = "ConsumedUnit")
    private String ConsumedUnit;

    @Column(name = "Contracted Cost", length = 800)
    @CsvBindByName(column = "ContractedCost")
    private double ContractedCost;

    @Column(name = "Contracted Unit Price", length = 800)
    @CsvBindByName(column = "ContractedUnitPrice")
    private double ContractedUnitPrice;

    @Column(name = "Effective Cost", length = 800)
    @CsvBindByName(column = "EffectiveCost")
    private double EffectiveCost;

    @Column(name = "Invoice Issuer", length = 800)
    @CsvBindByName(column = "InvoiceIssuer")
    private String InvoiceIssuerName;

    @Column(name = "List Cost", length = 800)
    @CsvBindByName(column = "ListCost")
    private double ListCost;

    @Column(name = "List Unit Price", length = 800)
    @CsvBindByName(column = "ListUnitPrice")
    private double ListUnitPrice;

    @Column(name = "Pricing Category", length = 800)
    @CsvBindByName(column = "PricingCategory")
    private String PricingCategory;

    @Column(name = "Pricing Quantity", length = 800)
    @CsvBindByName(column = "PricingQuantity")
    private double PricingQuantity;

    @Column(name = "Pricing Unit", length = 800)
    @CsvBindByName(column = "PricingUnit")
    private String PricingUnit;

    @Column(name = "Provider", length = 100)
    @CsvBindByName(column = "ProviderName")
    private String ProviderName;

    @Column(name = "Publisher", length = 110)
    @CsvBindByName(column = "PublisherName")
    private String PublisherName;

    @Column(name = "Region ID", length = 800)
    @CsvBindByName(column = "RegionId")
    private String RegionId;

    @Column(name = "Region Name", length = 800)
    @CsvBindByName(column = "RegionName")
    private String RegionName;

    @Column(name = "Resource ID", length = 800)
    @CsvBindByName(column = "ResourceID")
    private String ResourceId;

    @Column(name = "Resource Name", length = 800)
    @CsvBindByName(column = "ResourceName")
    private String ResourceName;

    @Column(name = "Resource Type", length = 800)
    @CsvBindByName(column = "ResourceType")
    private String ResourceType;

    @Column(name = "Service Category", length = 800)
    @CsvBindByName(column = "ServiceCategory")
    private String ServiceCategory;

    @Column(name = "Service Name", length = 800)
    @CsvBindByName(column = "ServiceName")
    private String ServiceName;

    @Column(name = "SKU ID", length = 800)
    @CsvBindByName(column = "SkuId")
    private String SkuId;

    @Column(name = "Sub Account ID", length = 800)
    @CsvBindByName(column = "SubAccountId")
    private String SubAccountId;

    @Column(name = "Sub Account Name", length = 800)
    @CsvBindByName(column = "SubAccountName")
    private String SubAccountName;

    @Column(name = "Tags", length = 800)
    @CsvBindByName(column = "Tags")
    private String Tags;
}