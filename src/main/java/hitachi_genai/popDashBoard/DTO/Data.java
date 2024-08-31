package hitachi_genai.popDashBoard.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Data {
    private List<Subscription> subscriptions;
    private double totalIncurredCost;
    private List<MonthlyIncurredCost> monthlyIncurredCost;
    private List<DailyIncurredCost> dailyIncurredCost;
}
