package fr.exanpe.t5.demo.pages.components.listSorter;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

import fr.exanpe.t5.demo.data.User;

public class Example1
{
    @Persist
    @Property
    private List<User> list;

    @Property
    private User element;

    void onActivate()
    {
        if (list == null)
        {
            init();
        }
    }

    void init()
    {
        list = new ArrayList<User>();
        list.add(createUser(1, "John", "Smith", 34));
        list.add(createUser(1, "Paul", "Carter", 58));
        list.add(createUser(1, "Simon", "Carpenter", 18));
        list.add(createUser(1, "Jill", "Valent", 24));
    }

    private User createUser(long id, String fname, String lname, int age)
    {
        User u = new User();
        u.setId(id);
        u.setFirstName(fname);
        u.setLastName(lname);
        u.setAge(age);
        return u;
    }
}
