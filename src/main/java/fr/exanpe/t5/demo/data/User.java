package fr.exanpe.t5.demo.data;

import java.io.Serializable;

import org.apache.tapestry5.beaneditor.NonVisual;

public class User implements Serializable
{
    @NonVisual
    private long id;

    private String firstName;

    private String lastName;

    private int age;

    public User()
    {
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}
