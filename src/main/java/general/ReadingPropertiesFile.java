package general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ReadingPropertiesFile {
    public static void readFile() {
        InputStream io = Thread.currentThread().getContextClassLoader().getResourceAsStream( "dd.txt" );
        Properties properties= new Properties();
        try {
            properties.load( io );
            String name = properties.getProperty( "name" );
            System.out.println( "value of property name : " + name );
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    static void creatingCustomProperties() {
        char[] alphabets = { 'a', 'b', 'c', 'd', 'e' };
        InputStreamReader inputStreamReader = new InputStreamReader( System.in );

        try ( BufferedReader bufferedReader = new BufferedReader( inputStreamReader ) ) {
            String read = bufferedReader.readLine();
            bufferedReader.close();
            if ( read != null ) {
                Properties creatingNewProperties = new Properties();
                creatingNewProperties.load( bufferedReader );
                System.out.println( creatingNewProperties.stringPropertyNames() );
            }
            inputStreamReader.close();

        } catch ( Exception e ) {
            e.printStackTrace();
        }

    }
}
