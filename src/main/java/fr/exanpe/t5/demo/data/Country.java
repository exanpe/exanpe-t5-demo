package fr.exanpe.t5.demo.data;

import java.io.Serializable;

public class Country implements Serializable
{
    private String id;
    private String name;

    public Country(String id, String name)
    {
        super();
        this.id = id;
        this.name = name;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
