package general.math;

import java.util.Arrays;

public class ImplementCalculate implements general.math.Calculate {

    public Integer addSubMulDiv( Integer[] listOfElements, String Operation ) {
        try {

            switch ( Operation ) {
                case "add":
                    return Arrays.stream( listOfElements ).reduce( 0, ( a, b ) -> a + b );
                case "sub":
                    return Arrays.stream( listOfElements ).reduce( 0, ( a, b ) -> a - b );
                case "mul":
                    return Arrays.stream( listOfElements ).reduce( 0, ( a, b ) -> a * b );
                case "div":
                    return Arrays.stream( listOfElements ).reduce( 0, ( a, b ) -> a / b );
                default:
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }

        return null;
    }
}
