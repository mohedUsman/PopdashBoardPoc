package hitachi_genai.popDashBoard.service;

import hitachi_genai.popDashBoard.Repository.FocusExportRepository;
import hitachi_genai.popDashBoard.model.FocusExport;
import hitachi_genai.popDashBoard.model.ResourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class FocusExportServiceImpl {

    @Autowired
    private FocusExportRepository focusExportRepository;
    public List<Object[]> getDailyCosts() {
        return focusExportRepository.finddCosts();
    }
}
