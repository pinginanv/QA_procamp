package com.povzhyk.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.povzhyk.configuration.models.Configuration;


import java.io.File;
import java.io.IOException;
import java.util.Map;


public class Configurator {

//set config variables via YAML file
    public static Configuration readResourseConfigFromYaml(String configFile) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = new File(classLoader.getResource(configFile).getFile());

        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        Configuration config = om.readValue(file, Configuration.class);

        System.out.println("Config info " + config.toString());
        System.out.println("Configuration from Yaml uploaded");

        return config;
    }

//set config variables via Environment variables
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


//set config variables inside Config class
    public static Configuration setDefaultConfig(String user, String password, String host){

        Configuration config = new Configuration();
        config.setUser(user);
        config.setPassword(password);
        config.setHost(host);

        System.out.println("Configuration is set");


        return config;
    }





}
