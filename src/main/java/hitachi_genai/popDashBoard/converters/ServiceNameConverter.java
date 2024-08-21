package hitachi_genai.popDashBoard.converters;

import com.opencsv.bean.AbstractBeanField;
import hitachi_genai.popDashBoard.enums.ServiceName;

public class ServiceNameConverter extends AbstractBeanField<ServiceName,String> {

    @Override
    protected ServiceName convert(String value) {
        return ServiceName.fromString(value);
    }
}
