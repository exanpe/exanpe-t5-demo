package fr.exanpe.t5.demo.base;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import fr.exanpe.t5.demo.services.AuthenticationService;

public class BaseAuthorize
{
    @Inject
    private AuthenticationService auth;

    @Property
    @Persist
    private String role;

    void onSuccess()
    {
        if (role != null && !role.equals(auth.getRole()))
        {
            auth.authenticate(role);
        }
    }

    public String getCurrentRole()
    {
        return auth.getRole();
    }
}
