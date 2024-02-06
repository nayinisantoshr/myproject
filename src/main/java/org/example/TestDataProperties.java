package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataProperties {

    static Properties properties = null;

    public static void load(){
        try (FileInputStream fileInput = new FileInputStream("src/test/resources/testData.properties")) {
            properties= new Properties();
            properties.load(fileInput);
        } catch (Exception e) {
            throw new RuntimeException("Properties File Not Found");
        }
    }

    public static String getData(String key){
        if(properties==null)
            load();
        return properties.getProperty(key);
    }

}
