package com.povzhyk.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.povzhyk.configuration.models.Configuration;


import java.io.File;
import java.io.IOException;
import java.util.Map;


public class Configurator {

    public static Configuration readResourseConfigFromYaml(String configFile) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = new File(classLoader.getResource(configFile).getFile());


        // Instantiating a new ObjectMapper as a YAMLFactory
        ObjectMapper om = new ObjectMapper(new YAMLFactory());

// Mapping the employee from the YAML file to the Employee class
        Configuration config = om.readValue(file, Configuration.class);

// Printing out the information
        System.out.println("Config info " + config.toString());

// Access the first element of the list and print it as well
        System.out.println("Accessing User element: " + config.getUser().toString());

        System.out.println("Configuration from Yaml uploaded");

        return config;
    }


    public static Configuration setConfigViaEnvVars(){

        Map<String, String> env = System.getenv();

        Configuration config = new Configuration();
        config.setUser(env.get("user"));
        config.setPassword(env.get("password"));
        config.setHost(env.get("host"));

        System.out.println(config.toString());
        System.out.println("Configuration set from Env Variables");

        return config;
    }



    public static Configuration setDefaultConfig(){

        Configuration config = new Configuration();
        config.setUser("def_user");
        config.setPassword("def_pass");
        config.setHost("https://cooker.net.ua/");

        System.out.println("Default Configuration is set");


        return config;
    }





}
