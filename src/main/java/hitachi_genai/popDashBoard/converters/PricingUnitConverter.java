package hitachi_genai.popDashBoard.converters;

import com.opencsv.bean.AbstractBeanField;
import hitachi_genai.popDashBoard.enums.PricingUnit;

public class PricingUnitConverter extends AbstractBeanField<PricingUnit, String> {
    @Override
    protected PricingUnit convert(String value) {
        return PricingUnit.fromString(value);
    }
}
