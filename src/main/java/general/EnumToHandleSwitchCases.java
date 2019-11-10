package general;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EnumToHandleSwitchCases {
    final static int millSecondsInADay = 24 * 60 * 60 * 1000;

    static long totalMillSeconds( DaysPerItem daysPerItem ) {
        DaysPerItem foundItem = daysPerItem.lookup( daysPerItem );
        return daysPerItem.getFieldValue( foundItem ) * millSecondsInADay;
    }


    public enum DaysPerItem {
        DAY( 1 ),
        WEEKLY( 7 ),
        BIWEEKLY( 14 ),
        MONTH( 30 ),
        YEAR( 365 );

        long days;

        DaysPerItem( long days ) {
            this.days = days;
        }


        long getFieldValue( DaysPerItem perItem ) {
            List<DaysPerItem> perItems = Arrays.stream( DaysPerItem.values() ).filter( e -> e.days == perItem.days ).collect( Collectors.toList() );
            return perItems.stream().findFirst().get().days;
        }


        DaysPerItem lookup( DaysPerItem perItem ) {
            return Arrays.stream( DaysPerItem.values() ).filter( e -> e.days == perItem.days ).collect( Collectors.toList() ).get( 0 );
        }
    }
}
