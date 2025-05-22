package Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadRegisterData {
	static String path = System.getProperty("user.dir")+"\\src\\main\\java\\Data\\Properties\\RegisterData.properties";
	
	public static Properties userData = loadProperties(path);

	private static Properties loadProperties(String path) {
		Properties pro = new Properties();
		try {
			FileInputStream stream = new FileInputStream(path);
			try {
				pro.load(stream);
			} catch (IOException e) {
				System.out.println("Error Occupied "+e.getMessage());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error Occupied "+e.getMessage());
		}
		
		return pro;
	}
}
