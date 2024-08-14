package hitachi_genai.popDashBoard.Repository;

import hitachi_genai.popDashBoard.model.FocusExport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FocusExportRepository extends JpaRepository<FocusExport, Integer> {
}
