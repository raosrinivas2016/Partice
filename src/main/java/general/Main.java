package general;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import sendingMail.EmailController;


@SpringBootApplication
@ComponentScan( basePackageClasses = EmailController.class )

public class Main implements Runnable {

    public static void main( String[] args ) {

        /* to launch spring application to send an email
        SpringApplication.run(Main.class,args);
        */

        //       /* JFrame f=new JFrame();
        //        WebAddressToIPTranslator watipt=new WebAddressToIPTranslator();
        //        f.setContentPane(watipt.test);
        //        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //        f.pack();
        //        f.setVisible(true);*/
        //
        ////       ReadingPropertiesFile readingPropertiesFile=new ReadingPropertiesFile();
        ////       readingPropertiesFile.readFile();
        //
        //
        //        long minActive=25*60*1000;
        //
        //        System.out.println(System.currentTimeMillis());
        //        System.out.println(System.currentTimeMillis());
        //        System.out.println(1000*60*24);
        //        System.out.println(1000*60*24);
        //        Person p1=new Person("1","r1");
        //        Person p2=new Person("2","r2");
        //        Person p3=new Person("3","r3");
        //        Person p4=new Person("4","r4");
        //        Person p5=new Person("5","r5");
        //        Person p6=new Person("6","r6");
        //
        //        Set<Person> personSet =new LinkedHashSet<>();
        //        personSet.add(p1);personSet.add(p2);personSet.add(p3);personSet.add(p4);personSet.add(p5);personSet.add(p6);

     /*   TestingConstructor testingConstructor = new TestingConstructor();
        GeneralIssues generalIssues = new GeneralIssues();
        generalIssues.emptyStringCheck();
        generalIssues.conditionCheckInsteadOfIfElse();
*/
        // stringTest();
//        test();
        /*Main m=new Main();
        new Thread( m).start();
*/

        System.out.println("no of milliSecs in day : "+EnumToHandleSwitchCases.totalMillSeconds( EnumToHandleSwitchCases.DaysPerItem.MONTH ));

    }

    private static void test() {
        ArrayList<general.Version> x1 = new ArrayList<>();
        ArrayList<String> x = new ArrayList<>();

        String version1 = "2017.02.0010Snapshot";
        String version2 = "2017.02.234";
        String version3 = "2017.02.0-Snapshot";

        x.add( version1 );
        x.add( version2 );
        x.add( version3 );

        for ( String v : x ) {
            String[] split = v.split( "\\." );
            if ( split[ 2 ].chars().allMatch( Character :: isDigit ) ) {
                Version version = new Version( version1 );
                x1.add( version );
            }
        }


        x1.forEach( x2 -> System.out.println( x2 ) );

    }

    public static void stringTest() {
        String name = "xyz,";
        String[] nameSplit = name.split( "," );
        String lname = nameSplit[ 0 ];
        String fname = nameSplit.length > 1 ? nameSplit[ 1 ] : "";
        System.out.println( lname );
        System.out.println( fname );
    }

    @Override
    public void run() {
        while ( true ){
            Stream classStream = Stream.of( Integer.class, String.class );
            Object collect = classStream.filter( e -> e.getClass().isInstance( Integer.class ) ).collect( Collectors.toList() );
            System.out.println(collect.getClass());

        }}



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


