package learnTesting;

public interface Calculator {
    Integer add( Integer... elements );

    Integer div( Integer... elements ) throws CustomException;

    Integer subtract( Integer... elements );

    Integer multiply( Integer... elements );

}
