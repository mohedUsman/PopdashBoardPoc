package hitachi_genai.popDashBoard.service;


import hitachi_genai.popDashBoard.DTO.CostRequest;
import hitachi_genai.popDashBoard.DTO.CostResponse;
import hitachi_genai.popDashBoard.dao.ServiceCategoryCostDAO;
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

     public List<ServiceCategoryCostResponse> getServiceCategoryCosts(ServiceCategoryCostRequests request) {
        return serviceCategoryCostDAO.getServiceCategoryCosts(request);
    }

    public List<ServiceCategoryBreakdownCostResponse> getServiceCategoryBreakdownCosts(ServiceCategoryCostRequests request) {
        return serviceCategoryCostDAO.getServiceCategoryBreakdownCosts(request);
    }

    public List<CostResponse> getCosts(CostRequest request) {
        return serviceCategoryCostDAO.getCosts(request);
    }

//    public CostResponse getCosts(CostRequest request) {
//        return serviceCategoryCostDAO.getCosts(request);
//    }
}