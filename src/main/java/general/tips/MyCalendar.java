package general.tips;

/*
 * formatting date in different styles
 * */
public class MyCalendar {

    /*
     *  @param  datePattern {@link String} to format
     *  @return prints formatted date
     *  @throws Throwable ->Exception -> RunTime Exception /Compile time Exception -> F
     * */
    public void test( String datePattern ) {
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat( datePattern );
        java.util.Date date = new java.util.Date();
        System.out.println( date );

        java.util.Calendar calendar = new java.util.GregorianCalendar();
        System.out.println( calendar );
        //        System.out.println(simpleDateFormat.format( calendar ));

    }
}
