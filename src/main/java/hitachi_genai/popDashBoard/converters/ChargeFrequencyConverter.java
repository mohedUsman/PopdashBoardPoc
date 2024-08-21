package hitachi_genai.popDashBoard.converters;

import com.opencsv.bean.AbstractBeanField;
import hitachi_genai.popDashBoard.enums.ChargeFrequency;

public class ChargeFrequencyConverter extends AbstractBeanField<ChargeFrequency,String> {
    @Override
    protected ChargeFrequency convert(String value) {
        return ChargeFrequency.fromString(value);
    }
}
