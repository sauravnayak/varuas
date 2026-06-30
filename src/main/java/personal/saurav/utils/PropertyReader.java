package personal.saurav.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private  static Properties property = new Properties();
    String filepath =System.getProperty("user.dir")+"/src/main/java/personal/saurav/utils/Project.properties";
    static {
        String filepath = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "main"
                + File.separator + "java"
                + File.separator + "personal"
                + File.separator + "saurav"
                + File.separator + "utils"
                + File.separator + "Project.properties";

        try (FileInputStream fs = new FileInputStream(filepath)) {
            property.load(fs);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load Project.properties file at: " + filepath, e);
        }
    }

        public static String getProperty(String key){
            return property.getProperty(key);
        }

        public static String getBrowser(){
            return property.getProperty("browser");
        }

        public static String getBaseURL(){
            return property.getProperty("baseurl");
        }

}
