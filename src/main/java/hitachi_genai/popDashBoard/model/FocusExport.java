package hitachi_genai.popDashBoard.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "focus_export")
@Entity
public class FocusExport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;

    @Column(name = "Availability Zone")
    private String AvailabilityZone;

    @Column(name = "Billed Cost")
    private double billedCost;

    @Column(name = "Billing Account ID")
    private String billingAccountId;

    @Column(name = "Billing Account Name")
    private String BillingAccountName;

    @Column(name = "Billing Currency")
    private String BillingCurrency;

    @Column(name = "Billing Period End")
    private Date BillingPeriodEnd;

    @Column(name = "Billing Period Start")
    private Date BillingPeriodStart;

    @Column(name = "Charge Category")
    private String ChargeCategory;

    @Column(name = "Charge Class")
    private String ChargeClass;

    @Column(name = "Charge Description")
    private String ChargeDescription;

    @Column(name = "Charge Frequency")
    private String ChargeFrequency;

    @Column(name = "Charge Period End")
    private Date ChargePeriodEnd;

    @Column(name = "Charge Period Start")
    private Date ChargePeriodStart;

    @Column(name = "Commitment Discount Category")
    private String CommitmentDiscountCategory;

    @Column(name = "Commitment Discount ID")
    private String CommitmentDiscountId;

    @Column(name = "Commitment Discount Name")
    private String CommitmentDiscountName;

    @Column(name = "Commitment Discount Status")
    private String CommitmentDiscountStatus;

    @Column(name = "Commitment Discount Type")
    private String CommitmentDiscountType;

    @Column(name = "Consumed Quantity")
    private double ConsumedQuantity;

    @Column(name = "Consumed Unit")
    private String ConsumedUnit;

    @Column(name = "Contracted Cost")
    private double ContractedCost;

    @Column(name = "Contracted Unit Price")
    private double ContractedUnitPrice;

    @Column(name = "Effective Cost")
    private double EffectiveCost;

    @Column(name = "Invoice Issuer")
    private String InvoiceIssuerName;

    @Column(name = "List Cost")
    private double ListCost;

    @Column(name = "List Unit Price")
    private double ListUnitPrice;

    @Column(name = "Pricing Category")
    private String PricingCategory;

    @Column(name = "Pricing Quantity")
    private double PricingQuantity;

    @Column(name = "Pricing Unit")
    private String PricingUnit;

    @Column(name = "Provider")
    private String ProviderName;

    @Column(name = "Publisher")
    private String PublisherName;

    @Column(name = "Region ID")
    private String RegionId;

    @Column(name = "Region Name")
    private String RegionName;

    @Column(name = "Resource ID")
    private String ResourceId;

    @Column(name = "Resource Name")
    private String ResourceName;

    @Column(name = "Resource Type")
    private String ResourceType;

    @Column(name = "Service Category")
    private String ServiceCategory;

    @Column(name = "Service Name")
    private String ServiceName;

    @Column(name = "SKU ID")
    private String SkuId;

    @Column(name = "Sub Account ID")
    private String SubAccountId;

    @Column(name = "Sub Account Name")
    private String SubAccountName;

    @Column(name = "Tags")
    private String Tags;

}
