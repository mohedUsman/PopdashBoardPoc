package hitachi_genai.popDashBoard.service;

import java.util.Date;
import java.util.List;

public interface FocusExportService {
   // public List<Object[]> getDailyCost();

    public List<Object[]> getCostForServiceCategory();

    public List<Object[]> getCostForServiceCategory(Date chargePeriodStart, Date chargePeriodEnd);

}
