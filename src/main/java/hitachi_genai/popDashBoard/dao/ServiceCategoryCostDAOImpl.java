package hitachi_genai.popDashBoard.dao;

import hitachi_genai.popDashBoard.DTO.*;
import hitachi_genai.popDashBoard.jdbcTemplateDTO.ServiceCategoryBreakdownCostResponse;
import hitachi_genai.popDashBoard.jdbcTemplateDTO.ServiceCategoryCostRequests;
import hitachi_genai.popDashBoard.jdbcTemplateDTO.ServiceCategoryCostResponse;
import hitachi_genai.popDashBoard.model.FocusExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ServiceCategoryCostDAOImpl implements ServiceCategoryCostDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ServiceCategoryCostResponse> getServiceCategoryCosts(ServiceCategoryCostRequests request) {
        String sql = "SELECT " +
                "c.sub_account_id, " +
                "c.sub_account_name, " +
                "CASE " +
                "WHEN ? = 'daily' THEN DATE_TRUNC('day', c.charge_period_start) " +
                "WHEN ? = 'monthly' THEN DATE_TRUNC('month', c.charge_period_start) " +
                "END AS period, " +
                "c.service_category, " +
                "c.billing_currency, " +
                "SUM(c.billed_cost) AS total_cost " +
                "FROM resource_usage_metrics_data c " +
                "WHERE c.charge_period_start >= ? " +
                "AND c.charge_period_end <= ? " +
                "AND (? IS NULL OR c.billing_currency = ?) " +
                "AND (? IS NULL OR c.provider_name = ANY(?)) " +
                "AND (? IS NULL OR c.sub_account_id = ANY(?)) " +
                "GROUP BY rollup(c.sub_account_id, c.sub_account_name, period, c.service_category, c.billing_currency) " +
                "ORDER BY c.sub_account_id, c.sub_account_name, period, c.service_category";

        return jdbcTemplate.query(sql, ps -> {
            ps.setString(1, request.getPeriodicity());
            ps.setString(2, request.getPeriodicity());
            ps.setDate(3, new java.sql.Date(request.getChargePeriodStart().getTime()));
            ps.setDate(4, new java.sql.Date(request.getChargePeriodEnd().getTime()));
            ps.setString(5, request.getBillingCurrency() != null ? request.getBillingCurrency().name() : null);
            ps.setString(6, request.getBillingCurrency() != null ? request.getBillingCurrency().name() : null);

            Array providerNamesArray = jdbcTemplate.getDataSource().getConnection().createArrayOf("text", request.getProviderName().toArray());
            ps.setArray(7, providerNamesArray);
            ps.setArray(8, providerNamesArray);

            Array subAccountIdsArray = jdbcTemplate.getDataSource().getConnection().createArrayOf("text", request.getSubAccountId().toArray());
            ps.setArray(9, subAccountIdsArray);
            ps.setArray(10, subAccountIdsArray);
        }, this::mapRowToServiceCategoryCostResponse);
    }

    @Override
    public List<ServiceCategoryBreakdownCostResponse> getServiceCategoryBreakdownCosts(ServiceCategoryCostRequests request) {
        String sql = "SELECT " +
                "c.sub_account_id, " +
                "c.sub_account_name, " +
                "CASE " +
                "WHEN ? = 'daily' THEN DATE_TRUNC('day', c.charge_period_start) " +
                "WHEN ? = 'monthly' THEN DATE_TRUNC('month', c.charge_period_start) " +
                "END AS period, " +
                "c.service_category, " +
                "c.billing_currency, " +
                "c.region_name, " +
                "c.resource_type, " +
                "c.charge_description, " +
                "SUM(c.billed_cost) AS total_cost " +
                "FROM resource_usage_metrics_data c " +
                "WHERE c.charge_period_start >= ? " +
                "AND c.charge_period_end <= ? " +
                "AND (? IS NULL OR c.billing_currency = ?) " +
                "AND (? IS NULL OR c.provider_name = ANY(?)) " +
                "AND (? IS NULL OR c.sub_account_id = ANY(?)) " +
                "GROUP BY rollup(c.sub_account_id, c.sub_account_name, period, c.service_category, c.billing_currency, c.region_name, c.resource_type, c.charge_description) " +
                "ORDER BY c.sub_account_id, c.sub_account_name, period, c.service_category, c.billing_currency, c.region_name, c.resource_type, c.charge_description";

        return jdbcTemplate.query(sql, ps -> {
            ps.setString(1, request.getPeriodicity());
            ps.setString(2, request.getPeriodicity());
            ps.setDate(3, new java.sql.Date(request.getChargePeriodStart().getTime()));
            ps.setDate(4, new java.sql.Date(request.getChargePeriodEnd().getTime()));
            ps.setString(5, request.getBillingCurrency() != null ? request.getBillingCurrency().name() : null);
            ps.setString(6, request.getBillingCurrency() != null ? request.getBillingCurrency().name() : null);

            Array providerNamesArray = jdbcTemplate.getDataSource().getConnection().createArrayOf("text", request.getProviderName().toArray());
            ps.setArray(7, providerNamesArray);
            ps.setArray(8, providerNamesArray);

            Array subAccountIdsArray = jdbcTemplate.getDataSource().getConnection().createArrayOf("text", request.getSubAccountId().toArray());
            ps.setArray(9, subAccountIdsArray);
            ps.setArray(10, subAccountIdsArray);
        }, this::mapRowToServiceCategoryBreakdownCostResponse);
    }



    @Override
    public List<CostResponse> getCosts(CostRequest request) {
        String sql = "SELECT " +
                "CASE " +
                "WHEN ? = 'daily' THEN DATE_TRUNC('day', c.charge_period_start) " +
                "WHEN ? = 'monthly' THEN DATE_TRUNC('month', c.charge_period_start) " +
                "END AS period, " +  // Alias the result as 'period'
                "SUM(c.billed_cost) AS incurredCost, " +
                "c.sub_account_name, " +
                "c.sub_account_id " +
                "FROM resource_usage_metrics_data c " +
                "WHERE c.charge_period_start >= ? AND c.charge_period_end <= ? " +
                "GROUP BY (c.sub_account_name, c.sub_account_id, period) " +
                "ORDER BY c.sub_account_name, c.sub_account_id, period";

        String periodicity = request.getPeriodicity();  // Capture periodicity value

        // Map to accumulate costs per subscription
        Map<String, CostResponse> costResponseMap = new HashMap<>();

        jdbcTemplate.query(sql, ps -> {
            ps.setString(1, periodicity);
            ps.setString(2, periodicity);
            ps.setDate(3, new java.sql.Date(request.getChargePeriodStart().getTime()));
            ps.setDate(4, new java.sql.Date(request.getChargePeriodEnd().getTime()));
        }, rs -> {
            String subscriptionId = rs.getString("sub_account_id");
            String subscriptionName = rs.getString("sub_account_name");

            CostResponse costResponse = costResponseMap.computeIfAbsent(subscriptionId, k -> {
                CostResponse response = new CostResponse();
                response.setMessage("Success");
                response.setData(new Data());
                response.getData().setSubscriptions(new ArrayList<>());
                response.getData().getSubscriptions().add(new Subscription(subscriptionId, subscriptionName));
                response.getData().setMonthlyIncurredCost(new ArrayList<>());
                response.getData().setDailyIncurredCost(new ArrayList<>());
                return response;
            });

            Data data = costResponse.getData();

            if ("monthly".equalsIgnoreCase(periodicity)) {
                MonthlyIncurredCost incurredCost = new MonthlyIncurredCost();
                incurredCost.setMonth(rs.getString("period"));
                incurredCost.setIncurredCost(rs.getDouble("incurredCost"));
                data.getMonthlyIncurredCost().add(incurredCost);
            } else {
                DailyIncurredCost incurredCost = new DailyIncurredCost();

                LocalDate date = rs.getDate("period").toLocalDate();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                incurredCost.setDate(date.format(formatter));

                incurredCost.setIncurredCost(rs.getDouble("incurredCost"));
                data.getDailyIncurredCost().add(incurredCost);
            }

            data.setTotalIncurredCost(data.getTotalIncurredCost() + rs.getDouble("incurredCost"));
        });

        return new ArrayList<>(costResponseMap.values());
    }



    private ServiceCategoryCostResponse mapRowToServiceCategoryCostResponse(ResultSet rs, int rowNum) throws SQLException {
        return new ServiceCategoryCostResponse(
                rs.getString("service_category"),
                rs.getBigDecimal("total_cost"),
                rs.getString("sub_account_id"),
                rs.getString("sub_account_name"),
                rs.getDate("period")
        );
    }

    private ServiceCategoryBreakdownCostResponse mapRowToServiceCategoryBreakdownCostResponse(ResultSet rs, int rowNum) throws SQLException {
        return new ServiceCategoryBreakdownCostResponse(
                rs.getString("service_category"),
                rs.getBigDecimal("total_cost"),
                rs.getString("billing_currency"),
                rs.getString("sub_account_id"),
                rs.getString("sub_account_name"),
                rs.getDate("period"),
                rs.getString("region_name"),
                rs.getString("resource_type"),
                rs.getString("charge_description")
        );
    }


    private static final String INSERT_SQL = "INSERT INTO resource_usage_metrics_data (" +
            "availability_zone, billed_cost, billing_account_id, billing_account_name, billing_currency, " +
            "billing_period_end, billing_period_start, charge_category, charge_class, charge_description, " +
            "charge_frequency, charge_period_end, charge_period_start, commitment_discount_category, " +
            "commitment_discount_id, commitment_discount_name, commitment_discount_status, commitment_discount_type, " +
            "consumed_quantity, consumed_unit, contracted_cost, contracted_unit_price, effective_cost, " +
            "invoice_issuer_name, list_cost, list_unit_price, pricing_category, pricing_quantity, pricing_unit, " +
            "provider_name, publisher_name, region_id, region_name, resource_id, resource_name, resource_type, " +
            "service_category, service_name, sku_id, sku_price_id, sub_account_id, sub_account_name, tags) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";



    @Override
    public void batchInsert(List<FocusExport> focusExports) {
        jdbcTemplate.batchUpdate(INSERT_SQL, focusExports, 1000, (PreparedStatement ps, FocusExport focusExport) -> {
            ps.setString(1, focusExport.getAvailabilityZone());
            ps.setBigDecimal(2, focusExport.getBilledCost());
            ps.setString(3, focusExport.getBillingAccountId());
            ps.setString(4, focusExport.getBillingAccountName());
            ps.setString(5, focusExport.getBillingCurrency() != null ? focusExport.getBillingCurrency().name() : null);
            ps.setTimestamp(6, new java.sql.Timestamp(focusExport.getBillingPeriodEnd().getTime()));
            ps.setTimestamp(7, new java.sql.Timestamp(focusExport.getBillingPeriodStart().getTime()));
            ps.setString(8, focusExport.getChargeCategory() != null ? focusExport.getChargeCategory().name() : null);
            ps.setString(9, focusExport.getChargeClass());
            ps.setString(10, focusExport.getChargeDescription());
            ps.setString(11, focusExport.getChargeFrequency() != null ? focusExport.getChargeFrequency().name() : null);
            ps.setTimestamp(12, new java.sql.Timestamp(focusExport.getChargePeriodEnd().getTime()));
            ps.setTimestamp(13, new java.sql.Timestamp(focusExport.getChargePeriodStart().getTime()));
            ps.setString(14, focusExport.getCommitmentDiscountCategory());
            ps.setString(15, focusExport.getCommitmentDiscountId());
            ps.setString(16, focusExport.getCommitmentDiscountName());
            ps.setString(17, focusExport.getCommitmentDiscountStatus());
            ps.setString(18, focusExport.getCommitmentDiscountType());
            ps.setBigDecimal(19, focusExport.getConsumedQuantity());
            ps.setString(20, focusExport.getConsumedUnit() != null ? focusExport.getConsumedUnit().name() : null);
            ps.setBigDecimal(21, focusExport.getContractedCost());
            ps.setBigDecimal(22, focusExport.getContractedUnitPrice());
            ps.setBigDecimal(23, focusExport.getEffectiveCost());
            ps.setString(24, focusExport.getInvoiceIssuerName());
            ps.setBigDecimal(25, focusExport.getListCost());
            ps.setBigDecimal(26, focusExport.getListUnitPrice());
            ps.setString(27, focusExport.getPricingCategory() != null ? focusExport.getPricingCategory().name() : null);
            ps.setBigDecimal(28, focusExport.getPricingQuantity());
            ps.setString(29, focusExport.getPricingUnit() != null ? focusExport.getPricingUnit().name() : null);
            ps.setString(30, focusExport.getProviderName());
            ps.setString(31, focusExport.getPublisherName());
            ps.setString(32, focusExport.getRegionId() != null ? focusExport.getRegionId().name() : null);
            ps.setString(33, focusExport.getRegionName() != null ? focusExport.getRegionName().name() : null);
            ps.setString(34, focusExport.getResourceId());
            ps.setString(35, focusExport.getResourceName());
            ps.setString(36, focusExport.getResourceType() != null ? focusExport.getResourceType().name() : null);
            ps.setString(37, focusExport.getServiceCategory() != null ? focusExport.getServiceCategory().name() : null);
            ps.setString(38, focusExport.getServiceName() != null ? focusExport.getServiceName().name() : null);
            ps.setString(39, focusExport.getSkuId());
            ps.setString(40, focusExport.getSkuPriceId());
            ps.setString(41, focusExport.getSubAccountId());
            ps.setString(42, focusExport.getSubAccountName() != null ? focusExport.getSubAccountName().name() : null);
            ps.setString(43, focusExport.getTags());
        });
    }
}
