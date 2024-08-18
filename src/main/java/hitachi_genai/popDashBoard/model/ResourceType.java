package hitachi_genai.popDashBoard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResourceType {
    //billing account name", "billing currency","resource type
    private String BillingAccountName;
    private String BillingCurrency;
    private String ResourceType;

    private Double billedCost;

}
