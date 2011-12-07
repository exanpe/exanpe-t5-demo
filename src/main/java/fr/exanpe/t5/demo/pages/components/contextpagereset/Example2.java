package fr.exanpe.t5.demo.pages.components.contextpagereset;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

import fr.exanpe.t5.lib.annotation.ContextPageReset;

public class Example2
{
    @Persist
    @Property
    private String value;

    @Persist
    @Property
    private int context;

    // required for Tapestry 5.3 compatibility
    void onActivate()
    {

    }

    void onActivate(int context)
    {
        this.context = context;
    }

    @ContextPageReset
    void resetPersist()
    {
        value = null;
    }
}
