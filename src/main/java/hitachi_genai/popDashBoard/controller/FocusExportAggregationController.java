package hitachi_genai.popDashBoard.controller;

import hitachi_genai.popDashBoard.dto.ServiceCategoryBreakDownCost;
import hitachi_genai.popDashBoard.dto.ServiceCategoryCost;
import hitachi_genai.popDashBoard.dto.ServiceCategoryCostRequest;
import hitachi_genai.popDashBoard.enums.*;
import hitachi_genai.popDashBoard.service.FocusExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/costs")
public class FocusExportAggregationController {

    @Autowired
    private FocusExportService focusExportService;

    @GetMapping("/costbyservice")
    public ResponseEntity<List<Object[]>> getTotalCostForServiceCategory() {
        try {
            List<Object[]> dailyCosts = focusExportService.getCostForServiceCategory();

            if (dailyCosts == null || dailyCosts.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No daily cost data found");
            }

            return ResponseEntity.ok(dailyCosts);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid subscription ID", e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while fetching daily costs", e);
        }
    }

//    @GetMapping("/costbyserviceDate")
//    public ResponseEntity<List<Object[]>> getTotalCostForServiceCategoryDate(
//            @RequestParam("chargePeriodStart") String chargePeriodStartStr,
//            @RequestParam("chargePeriodEnd") String chargePeriodEndStr) {
//        try {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
//            Date chargePeriodStart = dateFormat.parse(chargePeriodStartStr);
//            Date chargePeriodEnd = dateFormat.parse(chargePeriodEndStr);
//
//            List<Object[]> dailyCosts = focusExportService.getCostForServiceCategory(chargePeriodStart,chargePeriodEnd);
//
//            if (dailyCosts == null || dailyCosts.isEmpty()) {
//                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No daily cost data found");
//            }
//
//            return ResponseEntity.ok(dailyCosts);
//        } catch (IllegalArgumentException e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid subscription ID", e);
//        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while fetching daily costs", e);
//        }
//    }

 /**
    JSON for below API

    {
        "periodicity": "string",
            "infraCategory": "string",
            "chargePeriodStart": "2024-07-17T09:02:50.074Z",
            "chargePeriodEnd": "2024-07-23T09:02:50.074Z",
            "billingCurrency": "INR",
            "providerName": [
        "Microsoft"
  ],
        "subAccountId": [
        "/subscriptions/0f8c3763-9eeb-40f9-9037-2a5426da75e9"
  ]
    }

  **/
//    @PostMapping("/getAPI_2_ServiceCategory_Cost")
//    public ResponseEntity<List<ServiceCategoryCost>> getTotalAPI_2_ServiceCategory_Cost(
//            @RequestBody ServiceCategoryCostRequest request) {
//        List<Object[]> results = focusExportService.getAPI_2_ServiceCategory_Cost(request);
//        List<ServiceCategoryCost> response = results.stream().map(result ->{
//            ServiceCategoryCost cost = new ServiceCategoryCost();
//            cost.setPeriod((Date) result[0]);
//            cost.setServiceCategory(result[1].toString());
//            cost.setTotalCost((BigDecimal) result[2]);
//            cost.setProviderName((String) result[3]);
//            cost.setBillingCurrency(String.valueOf((BillingCurrency) result[4]));
//            cost.setSubAccountId((String) result[5]);
//            cost.setSubAccountName(String.valueOf((SubAccountName) result[6]));
//            cost.setOverallTotalCost((BigDecimal) result[7]);
//            return cost;
//        }).collect(Collectors.toList());
//
//
//        return ResponseEntity.ok(response);
//    }

 //   getfindAPI_3_ServiceCategory_BreakDown_Cost
    @PostMapping("/getAPI_3_ServiceCategory_BreakDown_Cost")
    public ResponseEntity<List<ServiceCategoryBreakDownCost>> getTotalAPI_3_ServiceCategory_BreakDown_Cost(
            @RequestBody ServiceCategoryCostRequest request) {
        List<Object[]> results = focusExportService.getAPI_3_ServiceCategory_BreakDown_Cost(request);
        List<ServiceCategoryBreakDownCost> response = results.stream().map(result ->{
            ServiceCategoryBreakDownCost cost = new ServiceCategoryBreakDownCost();
            cost.setPeriod((Date) result[0]);
            cost.setServiceCategory((ServiceCategory) result[1]);
            cost.setTotalCost((BigDecimal) result[2]);
            cost.setProviderName((String) result[3]);
            cost.setBillingCurrency((BillingCurrency) result[4]);
            cost.setRegionName((RegionName) result[5]);
            cost.setResourceType((ResourceType)(result[6]));
            cost.setChargeDescription((String) result[7]);
            cost.setSubAccountId((String) result[8]);
            cost.setSubAccountName(((SubAccountName) result[9]));
            cost.setOverallTotalCost((BigDecimal) result[10]);
            return cost;
        }).collect(Collectors.toList());


        return ResponseEntity.ok(response);
    }

}
