package hitachi_genai.popDashBoard.service;

import hitachi_genai.popDashBoard.dto.ServiceCategoryCostRequest;

import hitachi_genai.popDashBoard.DTO.ResourceUsageRequest;
import hitachi_genai.popDashBoard.DTO.ResourceUsageResponse;

import java.util.Date;
import java.util.List;

public interface FocusExportService {
   // public List<Object[]> getDailyCost();

    public List<Object[]> getCostForServiceCategory();

    public List<Object[]> getAPI_3_ServiceCategory_BreakDown_Cost(ServiceCategoryCostRequest request);

    List<Object[]> getAPI_2_ServiceCategory_Cost(ServiceCategoryCostRequest request);
    List<Object[]> totalCostByServiceCategoryAndSubAccount();
//    List<Object[]> getTotalCostByServiceCategoryAndSubAccount(Date startDate, Date endDate);

    public ResourceUsageResponse getResourceUsage(ResourceUsageRequest request);


}
