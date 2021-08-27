package ru.hereiam.faker.utils;

import java.io.*;
import java.util.Properties;

public class Property {

    public static Properties load(){
        try (InputStream in =  Property.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            prop.load(in);
            return prop;
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        return null;
    }

}
