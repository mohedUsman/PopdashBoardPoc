package hitachi_genai.popDashBoard.controller;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import hitachi_genai.popDashBoard.DTO.CostRequest;
import hitachi_genai.popDashBoard.DTO.CostResponse;
import hitachi_genai.popDashBoard.dao.ServiceCategoryCostDAO;
import hitachi_genai.popDashBoard.jdbcTemplateDTO.ServiceCategoryBreakdownCostResponse;
import hitachi_genai.popDashBoard.jdbcTemplateDTO.ServiceCategoryCostRequests;
import hitachi_genai.popDashBoard.jdbcTemplateDTO.ServiceCategoryCostResponse;
import hitachi_genai.popDashBoard.model.FocusExport;
import hitachi_genai.popDashBoard.service.jdbcTemplateCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@RestController
@RequestMapping("/api/jdbc-template")
public class JdbcTemplateController {

    @Autowired
    private jdbcTemplateCostService service;

    @Autowired
    private ServiceCategoryCostDAO serviceCategoryCostDAO;

    @PostMapping(value = "/upload-csv", consumes = {"multipart/form-data"})
    public String uploadCSV(@RequestParam("file") MultipartFile file) throws IOException {



        try(Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))){
            HeaderColumnNameMappingStrategy<FocusExport> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(FocusExport.class);

            CsvToBean<FocusExport> csvToBean = new CsvToBeanBuilder<FocusExport>(reader)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<FocusExport> records = csvToBean.parse();


            //List<FocusExport> focusExports = FocusExportrepository.saveAll(records);

            serviceCategoryCostDAO.batchInsert(records);


            //logger.info("Number of records saved: " + focusExports.size());
            return "File uploaded and data saved!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to process the file.";
        }
    }

    @PostMapping("/service-category-costs")
    public List<ServiceCategoryCostResponse> getServiceCategoryCosts(@RequestBody ServiceCategoryCostRequests request) {
        return service.getServiceCategoryCosts(request);

    }

    @PostMapping("/service-category-breakdown-costs")
    public List<ServiceCategoryBreakdownCostResponse> getServiceCategoryBreakdownCosts(@RequestBody ServiceCategoryCostRequests request) {
        return service.getServiceCategoryBreakdownCosts(request);
    }

    @PostMapping("/costs")
    public List<CostResponse> getCosts(@RequestBody CostRequest request) {
        return service.getCosts(request);
    }

}
