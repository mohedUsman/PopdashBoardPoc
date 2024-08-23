package hitachi_genai.popDashBoard.controller;

import hitachi_genai.popDashBoard.dto.ServiceCategoryCostRequest;
import hitachi_genai.popDashBoard.service.FocusExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    @GetMapping("/costbyserviceDate")
    public ResponseEntity<List<Object[]>> getTotalCostForServiceCategoryDate(
            @RequestParam("chargePeriodStart") String chargePeriodStartStr,
            @RequestParam("chargePeriodEnd") String chargePeriodEndStr) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
            Date chargePeriodStart = dateFormat.parse(chargePeriodStartStr);
            Date chargePeriodEnd = dateFormat.parse(chargePeriodEndStr);

            List<Object[]> dailyCosts = focusExportService.getCostForServiceCategory(chargePeriodStart,chargePeriodEnd);

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
    @PostMapping("/getAPI_2_ServiceCategory_Cost")
    public ResponseEntity<List<Object[]>> getTotalAPI_2_ServiceCategory_Cost(
            @RequestBody ServiceCategoryCostRequest request) {
        List<Object[]> response = focusExportService.getAPI_2_ServiceCategory_Cost(request);
        return ResponseEntity.ok(response);
    }




}
