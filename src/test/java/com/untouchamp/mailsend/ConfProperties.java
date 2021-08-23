package com.untouchamp.mailsend;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ConfProperties {
    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;
    static {
        try {
            //configuration file path
            fileInputStream = new FileInputStream("src/test/resources/conf.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            //in case we can't find a file, or it's not exist, or etc.
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace(); } } }
//    method that returns keys from config file
    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}