package hitachi_genai.popDashBoard.controller;

import hitachi_genai.popDashBoard.model.FocusExport;
import hitachi_genai.popDashBoard.model.ResourceType;
import hitachi_genai.popDashBoard.service.FocusExportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/costs")
public class AggregationController {

    @Autowired
    private FocusExportServiceImpl focusExportService;

    @GetMapping("/daily")
    public ResponseEntity<List<Object[]>> getDailyCosts() {
        try {
            List<Object[]> dailyCosts = focusExportService.getDailyCosts();

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

