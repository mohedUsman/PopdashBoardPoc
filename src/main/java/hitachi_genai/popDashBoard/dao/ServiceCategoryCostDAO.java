package hitachi_genai.popDashBoard.dao;

import hitachi_genai.popDashBoard.DTO.CostRequest;
import hitachi_genai.popDashBoard.DTO.CostResponse;
import hitachi_genai.popDashBoard.dto.CostResponse1;
import hitachi_genai.popDashBoard.dto.CostResponse2;
import hitachi_genai.popDashBoard.jdbcTemplateDTO.ServiceCategoryBreakdownCostResponse;
import hitachi_genai.popDashBoard.jdbcTemplateDTO.ServiceCategoryCostRequests;
import hitachi_genai.popDashBoard.jdbcTemplateDTO.ServiceCategoryCostResponse;

import java.util.List;

public interface ServiceCategoryCostDAO {
    List<CostResponse2> getServiceCategoryCosts(ServiceCategoryCostRequests request);
    List<CostResponse1> getServiceCategoryBreakdownCosts(ServiceCategoryCostRequests request);
    List<CostResponse> getCosts(CostRequest request);

}
