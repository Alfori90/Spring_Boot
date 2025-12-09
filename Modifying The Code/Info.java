package com.codeline.SpringBoot;

public class Info {
    private String name;
    private String city;
    private String language;

    public Info(String name, String city, String language) {
        this.name = name;
        this.city = city;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
