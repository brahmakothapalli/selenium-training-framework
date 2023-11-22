package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    static String filePath = System.getProperty("user.dir")+"/src/main/resources/configuration.properties";
    static Properties prop;
    static FileInputStream fis;

    public static Properties readConfigFile() throws IOException {
        prop = new Properties();
        fis = new FileInputStream(filePath);
        prop.load(fis);
        return prop;
    }
}
