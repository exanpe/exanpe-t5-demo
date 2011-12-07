package fr.exanpe.t5.demo.pages.components.contextpagereset;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

import fr.exanpe.t5.lib.annotation.ContextPageReset;

public class Example1
{
    @Persist
    @Property
    private String value;

    // required for Tapestry 5.3 compatibility
    void onActivate()
    {

    }

    @ContextPageReset
    void resetPersist()
    {
        value = null;
    }
}
