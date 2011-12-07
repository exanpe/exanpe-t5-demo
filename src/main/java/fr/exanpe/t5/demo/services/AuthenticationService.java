package fr.exanpe.t5.demo.services;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.RequestGlobals;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticationService
{

    @Inject
    private ApplicationContext applicationContext;

    @Inject
    private RequestGlobals request;

    public void authenticate(String role)
    {
        Authentication auth = new UsernamePasswordAuthenticationToken(role, role);
        Authentication result = ((AuthenticationManager) applicationContext.getBean(applicationContext.getBeanNamesForType(AuthenticationManager.class)[0]))
                .authenticate(auth);
        SecurityContextHolder.getContext().setAuthentication(result);
    }

    public String getRole()
    {
        return request.getHTTPServletRequest().getUserPrincipal() == null ? "" : request.getHTTPServletRequest().getUserPrincipal().getName();
    }
}
