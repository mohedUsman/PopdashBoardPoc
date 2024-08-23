package hitachi_genai.popDashBoard.service;

import hitachi_genai.popDashBoard.Repository.FocusExportRepository;
import hitachi_genai.popDashBoard.dto.ServiceCategoryCostRequest;
import hitachi_genai.popDashBoard.enums.BillingCurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FocusExportServiceImpl implements FocusExportService{

    @Autowired
    private FocusExportRepository focusExportRepository;
//    @Override
//    public List<Object[]> getDailyCost() {
//        return focusExportRepository.findCost();
//    }

    @Override
    public List<Object[]> getCostForServiceCategory() {
        return focusExportRepository.findTotalCostForServiceCategory();
    }

    @Override
    public List<Object[]> getCostForServiceCategory(Date chargePeriodStart, Date chargePeriodEnd) {
        return focusExportRepository.findTotalCostForServiceCategoryCustomDate(chargePeriodStart,chargePeriodEnd);
    }

    @Override
    public List<Object[]> getAPI_2_ServiceCategory_Cost(ServiceCategoryCostRequest request) {
        return focusExportRepository.findAPI_2_ServiceCategory_Cost(request.getChargePeriodStart(),request.getChargePeriodEnd(),request.getBillingCurrency(),request.getProviderName(),request.getSubAccountId());
    }
}
