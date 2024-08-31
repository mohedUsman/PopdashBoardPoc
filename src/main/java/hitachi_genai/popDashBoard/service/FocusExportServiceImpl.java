package hitachi_genai.popDashBoard.service;


import hitachi_genai.popDashBoard.Repository.FocusExportRepository;
import hitachi_genai.popDashBoard.dto.ServiceCategoryCostRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FocusExportServiceImpl implements FocusExportService{

    private static final Logger logger = LoggerFactory.getLogger(FocusExportServiceImpl.class);

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
    public List<Object[]> getAPI_3_ServiceCategory_BreakDown_Cost(ServiceCategoryCostRequest request) {
        return focusExportRepository.findAPI_3_ServiceCategory_BreakDown_Cost(request.getChargePeriodStart(),request.getChargePeriodEnd(),request.getBillingCurrency(),request.getProviderName(),request.getSubAccountId(),request.getPeriodicity());
    }


    @Override
    public List<Object[]> getAPI_2_ServiceCategory_Cost(ServiceCategoryCostRequest request) {
        return focusExportRepository.findAPI_2_ServiceCategory_Cost(request.getChargePeriodStart(),request.getChargePeriodEnd(),request.getBillingCurrency(),request.getProviderName(),request.getSubAccountId(),request.getPeriodicity());
    }



    @Override
    public List<Object[]> totalCostByServiceCategoryAndSubAccount() {
            List<Object[]> totalCostByServiceCategoryAndSubAccount = focusExportRepository.totalCostGroupedByServiceCategoryAndSubAccount();
                return focusExportRepository.totalCostGroupedByServiceCategoryAndSubAccount();
            }

}
