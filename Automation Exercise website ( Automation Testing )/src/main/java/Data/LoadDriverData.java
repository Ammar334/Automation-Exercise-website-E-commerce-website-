package Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadDriverData {
    private static final String PROPERTIES_PATH = System.getProperty("user.dir") + 
        "/src/main/java/Data/Properties/driverData.properties";
    
    public static final Properties userData = loadProperties();

    private static Properties loadProperties() {
        Properties pro = new Properties();
        try (FileInputStream stream = new FileInputStream(PROPERTIES_PATH)) {
            pro.load(stream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties from: " + PROPERTIES_PATH, e);
        }
        
        // Validate required properties
        return pro;
    }
}