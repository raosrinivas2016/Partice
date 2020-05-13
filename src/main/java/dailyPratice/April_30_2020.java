package dailyPratice;

import org.apache.cxf.common.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class April_30_2020 {

    public boolean isFaxNoValid( String faxNo ) {
        if ( !StringUtils.isEmpty( faxNo ) ) {
            Pattern pattern = Pattern.compile(
                    "^(\\+?\\d{1,}(\\s?|\\-?)\\d*(\\s?|\\-?)\\(?\\d{2,}\\)?(\\s?|\\-?)\\d{3,}\\s?\\d{3,})$" );
            Matcher matcher = pattern.matcher( faxNo );
            return matcher.matches();
        }
        return false;
    }
}
