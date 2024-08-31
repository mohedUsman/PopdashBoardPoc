package hitachi_genai.popDashBoard.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CostRequest {
    private Date chargePeriodStart;
    private Date chargePeriodEnd;
    private String periodicity;
    private List<String> subscriptions;
    private List<String> cspProvider;
    private String currency;
}
