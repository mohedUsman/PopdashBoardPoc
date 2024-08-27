package hitachi_genai.popDashBoard.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResourceUsageRequest {
    private Date ChargePeriodStart;
    private Date ChargePeriodEnd;
    private String periodicity;
    private List<String> cspProvider;
    private String currency;
    private List<String> subscriptions;

}