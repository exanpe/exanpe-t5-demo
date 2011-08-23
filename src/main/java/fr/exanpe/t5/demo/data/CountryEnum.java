package fr.exanpe.t5.demo.data;

import java.io.Serializable;

public enum CountryEnum implements Serializable
{
    FRANCE(new String[]
    { "Paris", "Lyon", "Marseille" }), UK(new String[]
    { "London", "Liverpool", "Manchester" }), USA(new String[]
    { "New York", "Washington", "Los Angeles", "San Francisco", "Miami" });

    private final String[] cities;

    private CountryEnum(String[] cities)
    {
        this.cities = cities;
    }

    public String[] getCities()
    {
        return cities;
    }
}
