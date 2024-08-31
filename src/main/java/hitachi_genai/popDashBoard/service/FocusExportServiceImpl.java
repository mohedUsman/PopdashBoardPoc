package hitachi_genai.popDashBoard.service;


import hitachi_genai.popDashBoard.Repository.FocusExportRepository;
import hitachi_genai.popDashBoard.dto.ServiceCategoryCostRequest;
import hitachi_genai.popDashBoard.model.FocusExport;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

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

//    @Override
//    public List<Object[]> findAPI_1_ServiceNameCost(ServiceOverAllCostRequest request) {
//        return focusExportRepository.findAPI_1_ServiceNameCost(request.getChargePeriodStart(),request.getChargePeriodEnd(),request.getBillingCurrency(),request.getProviderName(),request.getSubAccountName(),request.getPeriodicity());
//    }

    @Override
    public List<Object[]> getAPI_2_ServiceCategory_Cost(ServiceCategoryCostRequest request) {
        return focusExportRepository.findAPI_2_ServiceCategory_Cost(request.getChargePeriodStart(),request.getChargePeriodEnd(),request.getBillingCurrency(),request.getProviderName(),request.getSubAccountId(),request.getPeriodicity());
    }



    @Override
    public List<Object[]> totalCostByServiceCategoryAndSubAccount() {
            List<Object[]> totalCostByServiceCategoryAndSubAccount = focusExportRepository.totalCostGroupedByServiceCategoryAndSubAccount();
                return focusExportRepository.totalCostGroupedByServiceCategoryAndSubAccount();
            }

//    @Override
//    public List<Object[]> getTotalCostByServiceCategoryAndSubAccount(Date startDate, Date endDate) {
//        return focusExportRepository.totalCostGroupedByServiceCategoryAndSubAccount(startDate, endDate);
//    }

//    public ResourceUsageResponse getResourceUsage(ResourceUsageRequest request) {
//        List<FocusExport> focusExports = focusExportRepository.findByChargePeriodStartAndChargePeriodEnd(request.getChargePeriodStart(), request.getChargePeriodEnd());
//
//        // log the data inside the focusExports
//        //logger.info("focusExports data :::::: " + focusExports);
//
//
//
////        List<Subscription> subscriptions = focusExports.stream()
////                .collect(Collectors.groupingBy(FocusExport::getSubAccountId))
////                .entrySet().stream()
////                .map(entry -> new Subscription(entry.getKey(), entry.getValue()
////                        .stream().map(focusExport -> focusExport.getSubAccountName().name())
////                        .findFirst().orElse("")))
////                .collect(Collectors.toList());
//        List<Subscription> subscriptions = focusExports.stream()
//                .collect(Collectors.groupingBy(FocusExport::getSubAccountId))
//                .entrySet().stream()
//                .map(entry -> {
//                    String subAccountName = entry.getValue().stream()
//                            .map(focusExport -> focusExport.getSubAccountName() != null ? focusExport.getSubAccountName().name() : "SubAccountName not found")
//                            .findFirst()
//                            .orElse("SubAccountName not found");
//                    return new Subscription(entry.getKey(), subAccountName);
//                })
//                .collect(Collectors.toList());
//
//        BigDecimal totalCost = focusExports.stream()
//                .map(FocusExport::getBilledCost)
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//
//        List<CostDetail> monthlyCost = focusExports.stream()
//                .collect(Collectors.groupingBy(fe -> DateUtils.truncate(fe.getChargePeriodStart(), Calendar.MONTH)))
//                .entrySet().stream()
//                .map(entry -> new CostDetail(entry.getKey(), entry.getValue().stream().map(FocusExport::getBilledCost).reduce(BigDecimal.ZERO, BigDecimal::add)))
//                .collect(Collectors.toList());
//
//        ResourceUsageData data = new ResourceUsageData(subscriptions, totalCost, monthlyCost);
//        return new ResourceUsageResponse("Success", data);
//    }

}
