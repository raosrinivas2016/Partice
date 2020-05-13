package learnTesting;

import java.util.Arrays;

public class ImplementCalculator implements Calculator {
    @Override
    public Integer add( Integer... elements ) {
        return Arrays.stream( elements ).reduce( 0, ArithmeticUtils :: add );
    }

    @Override
    public Integer div( Integer... elements ) throws CustomException {
        Integer acc = 0;
        for ( Integer element : elements ) {
            acc = ArithmeticUtils.divide( acc, element );
        }
        return acc;
    }

    @Override
    public Integer subtract( Integer... elements ) {
        return Arrays.stream( elements ).reduce( 0, ArithmeticUtils :: add );

    }

    @Override
    public Integer multiply( Integer... elements ) {
        return Arrays.stream( elements ).reduce( 0, ArithmeticUtils :: add );

    }
}
