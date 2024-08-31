package hitachi_genai.popDashBoard.dao;

import hitachi_genai.popDashBoard.DTO.CostRequest;
import hitachi_genai.popDashBoard.DTO.CostResponse;
import hitachi_genai.popDashBoard.jdbcTemplateDTO.ServiceCategoryBreakdownCostResponse;
import hitachi_genai.popDashBoard.jdbcTemplateDTO.ServiceCategoryCostRequests;
import hitachi_genai.popDashBoard.jdbcTemplateDTO.ServiceCategoryCostResponse;

import java.util.List;

public interface ServiceCategoryCostDAO {
    List<ServiceCategoryCostResponse> getServiceCategoryCosts(ServiceCategoryCostRequests request);
    List<ServiceCategoryBreakdownCostResponse> getServiceCategoryBreakdownCosts(ServiceCategoryCostRequests request);
    List<CostResponse> getCosts(CostRequest request);
//    CostResponse getCosts(CostRequest request);

}
