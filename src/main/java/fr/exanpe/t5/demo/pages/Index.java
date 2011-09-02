package fr.exanpe.t5.demo.pages;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;

/**
 * Start page of application exanpe-t5-demo.
 */
public class Index
{
    private static final String GAE_HOSTNAME = "appspot.com";

    @Inject
    private Request request;

    public Boolean getIsGae()
    {
        return request.getServerName().contains(GAE_HOSTNAME);
    }
}
