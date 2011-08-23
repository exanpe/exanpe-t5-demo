package fr.exanpe.t5.demo.pages.components.securePassword;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

public class Example1
{
    @Property
    private String passwordValue;

    @Persist(PersistenceConstants.FLASH)
    @Property
    private String val;

    void onSubmit()
    {
        val = passwordValue;
    }

}
