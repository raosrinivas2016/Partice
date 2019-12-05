package general;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonStreamParser;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JasonParsertest {

    public void JsonParserFile( ) throws IOException {
        Gson gson = new Gson();
        List<User> usersList = new ArrayList<>();
        String file = "C:\\temp\\userJson.json";
        //        BufferedReader reader1 = new BufferedReader( new FileReader( file ) );
        //        String currentLine = reader1.readLine();
        //        System.out.println( currentLine );
        //        reader1.close();
        //
        //
        //        String file ="src/test/resources/test_read.txt";
        //        DataInputStream reader = new DataInputStream(new FileInputStream(file));
        //        String result = reader.readUTF();
        //        reader.close();


        //InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream( "src/main/java/general/dd.txt" );


        try ( Reader reader = new FileReader( file ) ) {


            DataInputStream dataInputStream = new DataInputStream( new FileInputStream( file ) );
            Reader reader1 = new InputStreamReader( dataInputStream, StandardCharsets.UTF_8 );
            Gson gson1 = new GsonBuilder().create();
            JsonStreamParser parser = new JsonStreamParser( reader1 );
            while ( parser.hasNext() ) {
                JsonElement e = parser.next();
                if ( e.isJsonObject() ) {
                    User user = gson1.fromJson( e, User.class );
                    usersList.add( user );
                }
            }


        } catch ( Exception e ) {
            e.printStackTrace();
        }

        System.out.println( usersList.size() );
    }


    public void test( ) {

        String StringToPasre = "[{\n" +
                                       "  \"id\": 12345678,\n" +
                                       "  \"name\": \"Denu\"\n" +
                                       "},\n" +
                                       "{\n" +
                                       "  \"id\": 12345678,\n" +
                                       "  \"name\": \"as2sd\"\n" +
                                       "},\n" +
                                       "{\n" +
                                       "  \"id\": 12345678,\n" +
                                       "  \"name\": \"asd1\"\n" +
                                       "}]\n";
        String json = "{ \"id1\":\"Hello\",\"id2\":\"how\"}";
        JsonParser parser = new JsonParser();


        JsonElement jsonTree = parser.parse( json );

        if ( jsonTree.isJsonObject() ) {
            JsonObject asJsonObject = jsonTree.getAsJsonObject();

            JsonElement f1 = asJsonObject.get( "id" );
            System.out.println( f1.toString() );
        }
    }


    public void whenReadWithBufferedReader_thenCorrect( )
            throws IOException {

        String file = "src/main/java/dd.txt";

        BufferedReader reader = new BufferedReader( new FileReader( file ) );
        String currentLine = reader.readLine();
        System.out.println( currentLine );
        reader.close();

    }

    public void davidTest( ) {

        String jsonString = "[\n" +
                                    "   {\n" +
                                    "      \"id\":\"one\",\n" +
                                    "      \"name\":\"two\"\n" +
                                    "   },\n" +
                                    "   {\n" +
                                    "      \"id\":\"three\",\n" +
                                    "      \"name\":\"four\"\n" +
                                    "   },\n" +
                                    "   {\n" +
                                    "      \"id\":\"five\",\n" +
                                    "      \"name\":\"six\"\n" +
                                    "   }\n" +
                                    "]";

        User[] secretsList = new Gson().fromJson( jsonString, User[].class );

        for ( User secrets : secretsList ) {
            System.out.println( secrets );
        }
    }


}
