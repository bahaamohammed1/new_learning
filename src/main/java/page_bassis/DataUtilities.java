package page_bassis;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataUtilities {
    private static final String Test_Data_path="src/test/resources/s/";
    public static String getjsondata(String filename,String field) throws FileNotFoundException {
        FileReader reader=new FileReader(Test_Data_path+filename+".json");
        JsonElement jsonElement= JsonParser.parseReader(reader);
        return jsonElement.getAsJsonObject().get(field).getAsString();

    }
    public static String properties(String filename,String field) throws IOException {
        Properties properties=new Properties();
        properties.load(new FileInputStream(Test_Data_path+filename+".properties"));
         return   properties.getProperty(field);

    }
}
