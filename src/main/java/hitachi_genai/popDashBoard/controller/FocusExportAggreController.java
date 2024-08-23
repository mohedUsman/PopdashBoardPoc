package hitachi_genai.popDashBoard.controller;

import hitachi_genai.popDashBoard.DTO.ResourceUsageRequest;
import hitachi_genai.popDashBoard.DTO.ResourceUsageResponse;
import hitachi_genai.popDashBoard.service.FocusExportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

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

    @PostMapping("fetch-data")
    public ResourceUsageResponse getResourceUsage(@RequestBody ResourceUsageRequest request) {
        return focusExportService.getResourceUsage(request);
    }

//    @GetMapping("/costByServiceCategorySubAccountDate")
//    public ResponseEntity<List<Object[]>> getTotalCostByServiceCategoryAndSubAccount(
//            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
//            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
//        try {
//            List<Object[]> results = focusExportService.getTotalCostByServiceCategoryAndSubAccount(startDate, endDate);
//            if (results == null || results.isEmpty()) {
//                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No data found");
//            }
//            return ResponseEntity.ok(results);
//        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while fetching data", e);
//        }
//    }
}
