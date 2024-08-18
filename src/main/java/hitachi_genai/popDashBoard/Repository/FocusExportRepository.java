package hitachi_genai.popDashBoard.Repository;

import hitachi_genai.popDashBoard.model.FocusExport;
import hitachi_genai.popDashBoard.model.ResourceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.Document;
import java.util.List;
import java.util.Objects;

@Repository
public interface FocusExportRepository extends JpaRepository<FocusExport, Integer> {

    @Query("SELECT c.BillingAccountName,c.BillingCurrency,c.ResourceType,SUM(c.billedCost) AS TotalCost FROM FocusExport c GROUP BY c.ResourceType,c.BillingAccountName,c.BillingCurrency")
    List<Object[]> finddCosts();
//GROUP BY c.ResourceType,c.BillingAccountName,c.BillingCurrency

    @Query(" SELECT f FROM FocusExport f ")
    List<Object[]> findAllaaa();
}
//
//SELECT "billing account name", "billing currency","resource type" ,SUM("billed cost") AS total_cost FROM focus_export GROUP BY "resource type","billing account name", "billing currency" ;