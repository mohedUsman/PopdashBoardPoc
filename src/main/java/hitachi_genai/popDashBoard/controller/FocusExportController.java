package hitachi_genai.popDashBoard.controller;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import hitachi_genai.popDashBoard.Repository.FocusExportRepository;
import hitachi_genai.popDashBoard.model.FocusExport;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.logging.Logger;


@RestController
public class FocusExportController {
    
    private static final Logger logger = Logger.getLogger(FocusExportController.class.getName());
    
    @Autowired
    private FocusExportRepository FocusExportrepository;

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


            List<FocusExport> focusExports = FocusExportrepository.saveAll(records);

            logger.info("Number of records saved: " + focusExports.size());
            return "File uploaded and data saved to MongoDB!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to process the file.";
        }
    }
}
