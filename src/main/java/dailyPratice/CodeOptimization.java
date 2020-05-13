package dailyPratice;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CodeOptimization {

    public List<Integer> getPatientLetters( int[] ids ) {

        Stream<Integer> integerStreamIds = Stream.of( 123, 2236, 345, 42345 );
        int[] emptyIntList = { };
        HashMap<Integer, Integer> appointmentTimesByLetterIds = new HashMap<>();

        for ( Integer id : Arrays.stream( emptyIntList ).boxed().collect( Collectors.toList() ) ) {

            if ( id > 0 ) {
                appointmentTimesByLetterIds.put( 23, id );
            }
        }
        TreeMap<Integer, Integer> lettersSortedByAppointmentTimes = new TreeMap<Integer, Integer>(
                appointmentTimesByLetterIds );
        Collection<Integer> values = lettersSortedByAppointmentTimes.values();

        Stream<Integer> StreamOfIntegers = Stream.of( 1, 2, 3, 4 );
        return StreamOfIntegers.collect( Collectors.toList() );
    }
}
