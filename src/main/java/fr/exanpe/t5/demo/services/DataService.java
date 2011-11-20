package fr.exanpe.t5.demo.services;

import java.util.ArrayList;
import java.util.List;

import fr.exanpe.t5.demo.data.City;
import fr.exanpe.t5.demo.data.Country;
import fr.exanpe.t5.demo.data.User;

public class DataService
{

    private User createUser(int id, String name, String firstName, int age)
    {
        User u = new User();
        u.setId(id);
        u.setLastName(name);
        u.setFirstName(firstName);
        u.setAge(age);
        return u;
    }

    public List<User> getListUsers()
    {
        List<User> users = new ArrayList<User>();

        for (int i = 0; i < 50; i++)
            users.add(createUser(i, "Name " + i, "First Name " + i, 20 + i));

        return users;
    }

    public List<String> getListOfString()
    {
        List<String> list = new ArrayList<String>();

        for (int i = 0; i < 30; i++)
            list.add("Hello World " + i);

        return list;
    }

    public List<Country> getCountryList()
    {
        List<Country> countries = new ArrayList<Country>();
        Country france = new Country("FRANCE", "France");
        Country uk = new Country("UK", "United Kingdom");
        Country usa = new Country("USA", "U.S.A");
        countries.add(france);
        countries.add(uk);
        countries.add(usa);
        return countries;
    }

    public List<City> getCityList()
    {
        List<City> cities = new ArrayList<City>();
        City paris = new City("PARIS", "Paris");
        City lyon = new City("LYON", "Lyon");
        City nantes = new City("NANTES", "Nantes");
        cities.add(paris);
        cities.add(lyon);
        cities.add(nantes);
        City london = new City("LONDON", "London");
        City manchester = new City("MANCHESTER", "Manchester");
        City liverpool = new City("LIVERPOOL", "Liverpool");
        cities.add(london);
        cities.add(manchester);
        cities.add(liverpool);
        City newyork = new City("NEWYORK", "New York");
        City washington = new City("WASHINGTON", "Washington");
        City losangeles = new City("LOSANGELES", "Los Angeles");
        City sanfrancisco = new City("SANFRANCISCO", "San Francisco");
        City miami = new City("MIAMI", "Miami");
        cities.add(newyork);
        cities.add(washington);
        cities.add(losangeles);
        cities.add(sanfrancisco);
        cities.add(miami);
        return cities;
    }

    public List<City> getCitiesByCountry(String countryId)
    {
        List<City> cities = new ArrayList<City>();
        if ("FRANCE".equals(countryId))
        {
            City paris = new City("PARIS", "Paris");
            City lyon = new City("LYON", "Lyon");
            City nantes = new City("NANTES", "Nantes");
            cities.add(paris);
            cities.add(lyon);
            cities.add(nantes);
        }
        if ("UK".equals(countryId))
        {
            City london = new City("LONDON", "London");
            City manchester = new City("MANCHESTER", "Manchester");
            City liverpool = new City("LIVERPOOL", "Liverpool");
            cities.add(london);
            cities.add(manchester);
            cities.add(liverpool);
        }
        if ("USA".equals(countryId))
        {
            City newyork = new City("NEWYORK", "New York");
            City washington = new City("WASHINGTON", "Washington");
            City losangeles = new City("LOSANGELES", "Los Angeles");
            City sanfrancisco = new City("SANFRANCISCO", "San Francisco");
            City miami = new City("MIAMI", "Miami");
            cities.add(newyork);
            cities.add(washington);
            cities.add(losangeles);
            cities.add(sanfrancisco);
            cities.add(miami);
        }
        return cities;
    }

    public Country findCountryById(String countryId)
    {
        Country country = null;
        for (Country c : this.getCountryList())
        {
            if (countryId.equals(c.getId()))
            {
                country = c;
                break;
            }
        }
        return country;
    }

    public City findCityById(String cityId)
    {
        City city = null;
        for (City c : this.getCityList())
        {
            if (cityId.equals(c.getId()))
            {
                city = c;
                break;
            }
        }
        return city;
    }
}
