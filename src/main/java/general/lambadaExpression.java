package general;

import Office.Person;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

class lambadaExpression {
    static Stream<Person> personStream = Stream.of( new Person( "33", "amani" ), new Person( "1", "raj" ) );

    static Stream<Person> sortedPersonStream() {

        Person[] personList = { new Person( "33", "amani" ), new Person( "1", "raj" ) };


        //        return personStream.sorted( ( o1, o2 ) -> o1.getID().compareTo( o2.getID() ) );
        //        List<Person> personList = personStream.collect( Collectors.toList() );
        Arrays.parallelSort( personList, Comparator.comparing( Person :: getID ) );
        //        personList.sort( Comparator.comparing( Person :: getID ) );
        return Arrays.stream( personList );

    }
}
