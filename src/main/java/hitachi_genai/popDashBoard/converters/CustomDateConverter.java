package hitachi_genai.popDashBoard.converters;

import com.opencsv.bean.AbstractBeanField;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateConverter extends AbstractBeanField<Date, String> {
    private static final String DATE_FORMAT = "yyyy-MM-dd"; // Adjust the format as needed

    @Override
    protected Date convert(String value) {
        try {
            return new SimpleDateFormat(DATE_FORMAT).parse(value);
        } catch (ParseException e) {
            throw new RuntimeException("Failed to parse date: " + value, e);
        }
    }
}
