package hitachi_genai.popDashBoard.service;

import hitachi_genai.popDashBoard.dto.ServiceCategoryCostRequest;

import hitachi_genai.popDashBoard.DTO.ResourceUsageRequest;
import hitachi_genai.popDashBoard.DTO.ResourceUsageResponse;

import java.util.Date;
import java.util.List;

public interface FocusExportService {

    public List<Object[]> getCostForServiceCategory();

    public List<Object[]> getCostForServiceCategory(Date chargePeriodStart, Date chargePeriodEnd);

    List<Object[]> getAPI_2_ServiceCategory_Cost(ServiceCategoryCostRequest request);

    List<Object[]> totalCostByServiceCategoryAndSubAccount();

    public ResourceUsageResponse getResourceUsage(ResourceUsageRequest request);


}
