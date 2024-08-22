package hitachi_genai.popDashBoard.controller;

import hitachi_genai.popDashBoard.service.FocusExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
            @RequestParam("chargePeriodStart") Date chargePeriodStart,
            @RequestParam("chargePeriodEnd") Date chargePeriodEnd) {
        try {
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

}
