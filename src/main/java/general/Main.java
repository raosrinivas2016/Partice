package general;

import dailyPratice.CodeOptimization;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import sendingMail.EmailController;

import java.util.Calendar;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@ComponentScan( basePackageClasses = EmailController.class )

public class Main implements Runnable {

    public static void main( String[] args ) {

        /* pratice develop changes*/
/*
        if(new April_30_2020().isFaxNoValid( "1-212-222 8888" )){
            System.out.println("given Fax no is in valid format");
        }
*/

        int[] ants = { 23, 231, 232 };
        new CodeOptimization().getPatientLetters( ants );

        /* to launch spring application to send an email
        SpringApplication.run(Main.class,args);
        */

               /* JFrame f=new JFrame();
                WebAddressToIPTranslator watipt=new WebAddressToIPTranslator();
                f.setContentPane(watipt.test);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.pack();
                f.setVisible(true);*/

/*
               ReadingPropertiesFile readingPropertiesFile=new ReadingPropertiesFile();
               readingPropertiesFile.readFile();
*/



/*              long minActive=25*60*1000;
                System.out.println(System.currentTimeMillis());
                System.out.println(System.currentTimeMillis());
                System.out.println(1000*60*24);
                System.out.println(1000*60*24);
                Person p1=new Person("1","r1");
                Person p2=new Person("2","r2");
                Person p3=new Person("3","r3");
                Person p4=new Person("4","r4");
                Person p5=new Person("5","r5");
                Person p6=new Person("6","r6");

                Set<Person> personSet =new LinkedHashSet<>();
                personSet.add(p1);personSet.add(p2);personSet.add(p3);personSet.add(p4);personSet.add(p5);personSet.add(p6);
*/
/*      TestingConstructor testingConstructor = new TestingConstructor();
        GeneralIssues generalIssues = new GeneralIssues();
        generalIssues.emptyStringCheck();
        generalIssues.conditionCheckInsteadOfIfElse();

        stringTest();
        test();
        Main m = new Main();
        new Thread( m).start();

        testingEnum();
        ReadingPropertiesFile.creatingCustomProperties();
*/
        //        ReadingPropertiesFile.readFile();
/*
        TODO
        whats the difference between map and foreach in stream ? check documentation once.
*/
        lambadaExpression.sortedPersonStream().forEach( Office.Person::printPerson );
        lambadaExpression.sortedPersonStream().map( Office.Person::printPerson );

        //        filterVersionObject();

        /*JasonParsertest jasonParser = new JasonParsertest();
        //jasonParser.JsonParserFile();

        jasonParser.davidTest();*/

        /*
        //Secrets out project : to read an endpoint*/
        /*System.out.println( "something is working" + SecretsServiceUtil.getLatestSecretsFromEndPoint( "nothing" ).toString() );*/

        /*Math Project :*/


        /*System.out.printf( "Result : %d %n", new general.math.ImplementCalculate().addSubMulDiv( new Integer[]{ 1, 2, 3 }, "add" ) );
        new general.tips.MyCalendar().test( "mm/dd/yyyy" );*/

        //        User u1 = new User( 1, "Abd.zb" );
        //        User u2 = new User( 2, "Abd.za" );
        //        List<User> users = new java.util.ArrayList<>();
        //        users.add( u1 );
        //        users.add( u2 );
        //        users.sort( User :: compareTo );
        //        //        users.stream().map( User::getName );
        //        for ( User a : users ) {
        //            System.out.println( a.getName() );
        //        }

        sortDate();
    }

    static void sortDate() {
        System.out.println( Calendar.getInstance().getTime() );
        System.out.println( Calendar.getInstance().getTimeInMillis() );
    }

    private static void testingEnum() {
        //        System.out.println("no of milliSecs in day : "+EnumToHandleSwitchCases.totalMillSeconds( EnumToHandleSwitchCases.DaysPerItem.MONTH ));

        System.out.println( statusEnum.valueOf( "COMPLETED" ) );
        EnumSet<statusEnum> pausedOrStopped = EnumSet.of( statusEnum.PAUSED, statusEnum.STOPPED );
        Stream<statusEnum> completedOrPaused = Stream.of( statusEnum.COMPLETED, statusEnum.PAUSED );
        List<statusEnum> startedButStopped = completedOrPaused.filter( pausedOrStopped::contains )
                                                              .collect( Collectors.toList() );
        System.out.println( "size of enum after filetring : " + startedButStopped.size() );
    }

    private static void filterVersionObject() {
        Stream.of( "2019.01.0-Snapshot", "2018.02.0010Snapshot", "2017.03.234" )
              .forEach( Main::filterStringToAddVersionObject );
    }

    private static void filterStringToAddVersionObject( String givenString ) {
        //        Stream.of( givenString.split( "\\." ) ).filter( s -> s.length() >= 2 ).forEach( e -> {
        //            Stream.of( givenString.split( "\\." ) ).Main.test( e[ 2 ] );
        //        } );
    }

    private static void test( String s1 ) {
        if ( s1.chars().allMatch( Character::isDigit ) ) {
            System.out.println( new Version( s1 ).toString() );
        }
    }

    public static void stringTest() {
        String name = "xyz,";
        String[] nameSplit = name.split( "," );
        String lName = nameSplit[ 0 ];
        String fName = nameSplit.length > 1 ? nameSplit[ 1 ] : "";
        System.out.println( lName );
        System.out.println( fName );
    }

    @Override
    public void run() {
        do {
            Stream classStream = Stream.of( Integer.class, String.class );
            Object collect = classStream.filter( e -> e.getClass().isInstance( Integer.class ) ).collect( Collectors.toList() );
            System.out.println( collect.getClass() );

        } while ( true );
    }





        /*public static Set<Person> removeDuplicates( Set<Person> PersonSet ) {

            Person p4 = new Person( "4", "r4" );
            Person p5 = new Person( "5", "r5" );
            Person p6 = new Person( "6", "r6" );
            Set<Person> duplicatePersonSet = new LinkedHashSet<>();
            duplicatePersonSet.add( p4 );
            duplicatePersonSet.add( p5 );
            duplicatePersonSet.add( p6 );

            Set<Person> PersonList = Stream.concat( PersonSet.stream(), duplicatePersonSet.stream() ).collect( Collectors.toSet() );

            //check difference between anyMatch() , allMatch() & noneMatch()
            //anyMatch()
            boolean b = duplicatePersonSet.stream().anyMatch( e -> e.getID().equals( "1" ) );
            Optional<Person> pq1 = duplicatePersonSet.stream().findAny();


            //allMatch()
            if ( duplicatePersonSet.stream().allMatch( x -> x.getName() ) ) {
                System.out.println( "all match works" );
            }
            //noneMatch()
            Optional<Person> pe1 = duplicatePersonSet.stream().findAny();
            Integer[] i = { 1, 2, 3, 4 };
            String[] s = { "a3", "a2", "2323a1" };
            String c = Arrays.stream( s ).skip( 1 ).findFirst().get();
            int[] i1 = Arrays.stream( i ).mapToInt( e -> e ).toArray();
            List<Integer> LA = new LinkedList<>( Arrays.asList( i ) );
            List<Integer> LAClone = ( List<Integer> ) ( ( LinkedList<Integer> ) LA ).clone();
            if ( Arrays.stream( i ).noneMatch( e -> e.equals( 22 ) ) ) {
                System.out.println( "none match works" );
            }

            return PersonList;
        }

         */
}


