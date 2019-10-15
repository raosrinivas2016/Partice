package general;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadingPropertiesFile {
    public void readFile(){
        InputStream io=Thread.currentThread().getContextClassLoader().getResourceAsStream("dd.txt");
        Properties properties= new Properties();
        try {
            properties.load(io);
            String name=properties.getProperty("name");
            System.out.println("reading contents from properties file and export them Properties class in java and uisng them in Project");
            System.out.println("value of property name : "+name);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
