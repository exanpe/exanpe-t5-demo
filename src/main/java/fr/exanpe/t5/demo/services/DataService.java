package fr.exanpe.t5.demo.services;

import java.util.ArrayList;
import java.util.List;

import fr.exanpe.t5.demo.data.CountryEnum;
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

    public String[] getCitiesFromCountry(CountryEnum e)
    {
        return e.getCities();
    }
}
