package hitachi_genai.popDashBoard.service;

import hitachi_genai.popDashBoard.Repository.FocusExportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FocusExportServiceImpl implements FocusExportService{

    @Autowired
    private FocusExportRepository focusExportRepository;
    @Override
    public List<Object[]> getDailyCost() {
        return focusExportRepository.findCost();
    }
}
