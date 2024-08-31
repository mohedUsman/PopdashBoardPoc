package hitachi_genai.popDashBoard.controller;

//import hitachi_genai.popDashBoard.DTO.ResourceUsageResponse;
import hitachi_genai.popDashBoard.enums.BillingCurrency;
import hitachi_genai.popDashBoard.enums.SubAccountName;
import hitachi_genai.popDashBoard.service.FocusExportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/focus-export")
public class FocusExportAggreController {
    @Autowired
    private FocusExportServiceImpl focusExportService;

    @GetMapping("/costByServiceCategorySubAccount")
    public ResponseEntity<List<Object[]>> getTotalCostByServiceCategoryAndSubAccount()
            {
        try {
            List<Object[]> results = focusExportService.totalCostByServiceCategoryAndSubAccount();
            if (results == null || results.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No data found");
            }
            return ResponseEntity.ok(results);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while fetching data", e);
        }
    }


//    @PostMapping("/getAPI_1_SubAccountName_Cost")
//    public ResponseEntity<List<SubAccountNameCost>> API1_SubAccountNameCost(
//            @RequestBody ServiceOverAllCostRequest request) {
//        List<Object[]> results = focusExportService.findAPI_1_ServiceNameCost(request);
//        List<SubAccountNameCost> response = results.stream().map(result ->{
//            SubAccountNameCost cost = new SubAccountNameCost();
//            cost.setPeriod((Date) result[0]);
//            cost.setTotalCost((BigDecimal) result[1]);
//            cost.setProviderName((String) result[2]);
//            cost.setBillingCurrency((BillingCurrency) result[3]);
//           // cost.setSubAccountId((String) result[5]);
//            cost.setSubAccountName((SubAccountName) result[4]);
//            cost.setOverallTotalCost((BigDecimal) result[5]);
//            return cost;
//        }).collect(Collectors.toList());
//
//        return  ResponseEntity.ok(response);
//    }
}
