package learnTesting;

public class ArithmeticUtils extends Exception {
    public static Integer add( Integer a, Integer b ) {
        return a + b;
    }

    public static Integer divide( Integer a, Integer b ) throws CustomException {
        if ( b == 0 ) {
            throw new CustomException( "divide by Zero", new Throwable() );
        }
        return a / b;
    }
}
/*
 *
 * extend a Exception class then your class becomes custom exception class.
 * how to create a custom Exception
 * class childException extends Exception{
 * a(){
 * super("myCustomException")
 * }
 * }
 *
 * class a{
 * void test1() throws childException {
 * int a=1;
 * int b=0;
 * if(b==0){
 * throw new childException();}
 * }
 * }
 *
 * */