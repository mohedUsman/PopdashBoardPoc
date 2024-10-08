package hitachi_genai.popDashBoard.service;


import hitachi_genai.popDashBoard.DTO.CostRequest;
import hitachi_genai.popDashBoard.DTO.CostResponse;
import hitachi_genai.popDashBoard.dao.ServiceCategoryCostDAO;
import hitachi_genai.popDashBoard.dto.CostResponse1;
import hitachi_genai.popDashBoard.dto.CostResponse2;
import hitachi_genai.popDashBoard.jdbcTemplateDTO.ServiceCategoryBreakdownCostResponse;
import hitachi_genai.popDashBoard.jdbcTemplateDTO.ServiceCategoryCostRequests;
import hitachi_genai.popDashBoard.jdbcTemplateDTO.ServiceCategoryCostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class jdbcTemplateCostService {

     @Autowired
     private ServiceCategoryCostDAO serviceCategoryCostDAO;

     public List<CostResponse2> getServiceCategoryCosts(ServiceCategoryCostRequests request) {
        return serviceCategoryCostDAO.getServiceCategoryCosts(request);
    }

    public List<CostResponse1> getServiceCategoryBreakdownCosts(ServiceCategoryCostRequests request) {
        return serviceCategoryCostDAO.getServiceCategoryBreakdownCosts(request);
    }

    public List<CostResponse> getCosts(CostRequest request) {
        return serviceCategoryCostDAO.getCosts(request);
    }

}