package fr.exanpe.t5.demo.pages.components.dialog;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

public class Example5
{
    @Persist(PersistenceConstants.FLASH)
    @Property
    private String username;

}
