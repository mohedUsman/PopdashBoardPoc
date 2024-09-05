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
public class ServicesName {


    private String serviceName;
  //  private BigDecimal serviceCost;
  //  private int subServiceCount;
    private List<SubServiceName> subServiceNames;
}
