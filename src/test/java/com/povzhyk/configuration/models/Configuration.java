package com.povzhyk.configuration.models;

import lombok.Getter;
import lombok.Setter;

public class Configuration {

    @Getter
    @Setter
    private String User;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String host;

    public Configuration(String user, String password, String host) {
        User = user;
        this.password = password;
        this.host = host;
    }
    public Configuration(){

    }

    @Override
    public String toString() {
        return "Configuration{" +
                "User='" + User + '\'' +
                ", password='" + password + '\'' +
                ", host='" + host + '\'' +
                '}';
    }

}
