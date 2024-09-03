package hitachi_genai.popDashBoard.controller;

import hitachi_genai.popDashBoard.DTO.CostRequest;
import hitachi_genai.popDashBoard.DTO.CostResponse;
import hitachi_genai.popDashBoard.dto.CostResponse1;
import hitachi_genai.popDashBoard.jdbcTemplateDTO.ServiceCategoryBreakdownCostResponse;
import hitachi_genai.popDashBoard.jdbcTemplateDTO.ServiceCategoryCostRequests;
import hitachi_genai.popDashBoard.jdbcTemplateDTO.ServiceCategoryCostResponse;
import hitachi_genai.popDashBoard.service.jdbcTemplateCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jdbc-template")
public class JdbcTemplateController {

    @Autowired
    private jdbcTemplateCostService service;

    @PostMapping("/service-category-costs")
    public List<ServiceCategoryCostResponse> getServiceCategoryCosts(@RequestBody ServiceCategoryCostRequests request) {
        return service.getServiceCategoryCosts(request);

    }

    @PostMapping("/service-category-breakdown-costs")
    public List<CostResponse1> getServiceCategoryBreakdownCosts(@RequestBody ServiceCategoryCostRequests request) {
        return service.getServiceCategoryBreakdownCosts(request);
    }

    @PostMapping("/costs")
    public List<CostResponse> getCosts(@RequestBody CostRequest request) {
        return service.getCosts(request);
    }

}
