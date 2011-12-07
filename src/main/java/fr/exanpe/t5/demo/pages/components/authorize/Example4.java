package fr.exanpe.t5.demo.pages.components.authorize;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

import fr.exanpe.t5.demo.base.BaseAuthorize;
import fr.exanpe.t5.lib.annotation.Authorize;

public class Example4 extends BaseAuthorize
{
    @Property
    @Persist(PersistenceConstants.FLASH)
    private String result;

    @OnEvent(value = EventConstants.ACTION, component = "trigger")
    @Authorize(all = "ROLE_USER")
    void clickUser()
    {
        System.out.println("role");
        result = "Role route called";
    }

    @OnEvent(value = EventConstants.ACTION, component = "trigger")
    @Authorize(all = "ROLE_ADMIN")
    void clickAdmin()
    {
        System.out.println("admin");
        result = "Admin route used";
    }

    @OnEvent(value = EventConstants.ACTION, component = "trigger")
    @Authorize(not =
    { "ROLE_USER", "ROLE_ADMIN" })
    void clickAnonymous()
    {
        System.out.println("ano");
        result = "Anonymous route triggered on server";
    }
}
