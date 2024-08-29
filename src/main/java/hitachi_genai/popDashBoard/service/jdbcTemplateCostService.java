package hitachi_genai.popDashBoard.service;

import hitachi_genai.popDashBoard.Repository.JdbcTemplateRepository;

import hitachi_genai.popDashBoard.jdbcTemplateDTO.ServiceCategoryBreakdownCostResponse;
import hitachi_genai.popDashBoard.jdbcTemplateDTO.ServiceCategoryCostRequests;
import hitachi_genai.popDashBoard.jdbcTemplateDTO.ServiceCategoryCostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class jdbcTemplateCostService {

    @Autowired
    private JdbcTemplateRepository repository;

    public List<ServiceCategoryCostResponse> getServiceCategoryCosts(ServiceCategoryCostRequests request) {
        return repository.getServiceCategoryCosts(request);
}

    public List<ServiceCategoryBreakdownCostResponse> getServiceCategoryBreakdownCosts(
            ServiceCategoryCostRequests request) {
        return repository.getServiceCategoryBreakdownCosts(request);
    }
}