package hitachi_genai.popDashBoard.Repository;

import hitachi_genai.popDashBoard.enums.BillingCurrency;
import hitachi_genai.popDashBoard.model.FocusExport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FocusExportRepository extends JpaRepository<FocusExport, Integer> {

//    @Query("SELECT c.BillingAccountName,c.BillingCurrency,c.ResourceType,SUM(c.billedCost) AS TotalCost FROM resource_usage_metrics_data c GROUP BY c.ResourceType,c.BillingAccountName,c.BillingCurrency")
//    List<Object[]> findCost();

  //  @Query("SELECT c.ServiceCategory, SUM(c.billedCost) AS TotalCost ,c.BillingCurrency, c.ChargePeriodEnd, c.ChargePeriodStart, c.ConsumedQuantity, c.ConsumedUnit, c.RegionName, c.ResourceName, c.ResourceType FROM FocusExport c GROUP BY c.ServiceCategory,c.BillingCurrency")
  @Query("SELECT c.ServiceCategory, SUM(c.billedCost) AS TotalCost, " +
          "c.BillingCurrency,  " +
          "  c.RegionName, c.ResourceType , c.SubAccountId , c.SubAccountName ,c.ChargeDescription " +
          "FROM FocusExport c " +
          "GROUP BY c.ServiceCategory, c.BillingCurrency, " +
          " c.RegionName, c.ResourceType,c.SubAccountId , c.SubAccountName,c.ChargeDescription")
  List<Object[]> findTotalCostForServiceCategory();


  @Query("SELECT " +
          "CASE WHEN :periodicity = 'daily' THEN DATE_TRUNC('day', c.ChargePeriodStart) " +
          "     WHEN :periodicity = 'monthly' THEN DATE_TRUNC('month', c.ChargePeriodStart) " +
          "END AS period, " +
          "c.ServiceCategory, SUM(c.billedCost) AS TotalCost ,c.ProviderName , c.BillingCurrency , c.RegionName, c.ResourceType , c.ChargeDescription ,c.SubAccountId , c.SubAccountName, " +
          "(SELECT SUM(c2.billedCost) FROM FocusExport c2 WHERE c2.ServiceCategory = c.ServiceCategory) AS OverallTotalCost " +
          "FROM FocusExport c " +
          "WHERE c.ChargePeriodStart >= :chargePeriodStart AND c.ChargePeriodEnd <= :chargePeriodEnd " +
          "AND (:currency IS NULL OR c.BillingCurrency = :currency) " +
          "AND (:cspProvider IS NULL OR c.ProviderName IN :cspProvider) " +
          "AND (:subAccountId IS NULL OR c.SubAccountId IN :subAccountId) " +
          "GROUP BY period,c.ServiceCategory ,c.ProviderName , c.BillingCurrency, c.RegionName, c.ResourceType , c.ChargeDescription, c.SubAccountId , c.SubAccountName ")
  List<Object[]> findAPI_3_ServiceCategory_BreakDown_Cost(
          @Param("chargePeriodStart") Date chargePeriodStart,
          @Param("chargePeriodEnd") Date chargePeriodEnd,
          @Param("currency") BillingCurrency currency,
          @Param("cspProvider") List<String> cspProvider,
          @Param("subAccountId") List<String> subAccountId,
          @Param("periodicity") String periodicity);




  /** Working method for API_2  **/

  @Query("SELECT " +
          "CASE WHEN :periodicity = 'daily' THEN DATE_TRUNC('day', c.ChargePeriodStart) " +
          "     WHEN :periodicity = 'monthly' THEN DATE_TRUNC('month', c.ChargePeriodStart) " +
          "END AS period, " +
          "c.ServiceCategory, SUM(c.billedCost) AS TotalCost ,c.ProviderName , c.BillingCurrency ,c.SubAccountId , c.SubAccountName, " +
          "(SELECT SUM(c2.billedCost) FROM FocusExport c2 WHERE c2.ServiceCategory = c.ServiceCategory) AS OverallTotalCost " +
          "FROM FocusExport c " +
          "WHERE c.ChargePeriodStart >= :chargePeriodStart AND c.ChargePeriodEnd <= :chargePeriodEnd " +
          "AND (:currency IS NULL OR c.BillingCurrency = :currency) " +
          "AND (:cspProvider IS NULL OR c.ProviderName IN :cspProvider) " +
            "AND (:subAccountId IS NULL OR c.SubAccountId IN :subAccountId) " +
          "GROUP BY period,c.ServiceCategory ,c.ProviderName , c.BillingCurrency,c.SubAccountId , c.SubAccountName ")
  List<Object[]> findAPI_2_ServiceCategory_Cost(
          @Param("chargePeriodStart") Date chargePeriodStart,
          @Param("chargePeriodEnd") Date chargePeriodEnd,
          @Param("currency") BillingCurrency currency,
          @Param("cspProvider") List<String> cspProvider,
          @Param("subAccountId") List<String> subAccountId,
          @Param("periodicity") String periodicity);




  @Query("SELECT c.ServiceCategory, c.ServiceName, c.SubAccountId, c.SubAccountName, SUM(c.billedCost) " +
          "FROM FocusExport c " +
          "GROUP BY c.ServiceCategory, c.ServiceName, c.SubAccountId, c.SubAccountName")
  List<Object[]> totalCostGroupedByServiceCategoryAndSubAccount();



  @Query(value = "SELECT * FROM resource_usage_metrics_data WHERE resource_usage_metrics_data.charge_period_start >= :start AND resource_usage_metrics_data.charge_period_end <= :end", nativeQuery = true)
  List<FocusExport> findByChargePeriodStartAndChargePeriodEnd(@Param("start") Date chargePeriodStart, @Param("end") Date chargePeriodEnd);
//  @Query("SELECT c.ServiceCategory, c.ServiceName, c.SubAccountId, c.SubAccountName, SUM(c.billedCost) " +
//          "FROM FocusExport c " +
//          "WHERE c.ChargePeriodStart >= :StartDate AND c.ChargePeriodEnd <= :EndDate " +
//          "GROUP BY c.ServiceCategory, c.ServiceName, c.SubAccountId, c.SubAccountName")
//  List<Object[]> totalCostGroupedByServiceCategoryAndSubAccount(
//          @Param("startDate") Date startDate,
//          @Param("endDate") Date endDate);

}

