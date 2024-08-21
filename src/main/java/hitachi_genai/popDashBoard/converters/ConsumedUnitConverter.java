package hitachi_genai.popDashBoard.converters;

import com.opencsv.bean.AbstractBeanField;
import hitachi_genai.popDashBoard.enums.ConsumedUnit;

public class ConsumedUnitConverter extends AbstractBeanField<ConsumedUnit,String> {
    @Override
    protected ConsumedUnit convert(String value) {
        return ConsumedUnit.fromString(value);
    }
}
