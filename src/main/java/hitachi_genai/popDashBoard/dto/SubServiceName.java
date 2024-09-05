package hitachi_genai.popDashBoard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubServiceName {

    private String chargeDescriptionName;
    private BigDecimal chargeDescriptionCost;
    private List<IncurredCost> incurredCosts;
}
