package hitachi_genai.popDashBoard.dao;

import hitachi_genai.popDashBoard.jdbcTemplateDTO.ServiceCategoryBreakdownCostResponse;
import hitachi_genai.popDashBoard.jdbcTemplateDTO.ServiceCategoryCostRequests;
import hitachi_genai.popDashBoard.jdbcTemplateDTO.ServiceCategoryCostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
}
