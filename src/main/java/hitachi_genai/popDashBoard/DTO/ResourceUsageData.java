package hitachi_genai.popDashBoard.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResourceUsageData {
    private List<Subscription> subscriptions;
    private BigDecimal totalCost;
    private List<MonthlyCost> monthlyCost;
}
