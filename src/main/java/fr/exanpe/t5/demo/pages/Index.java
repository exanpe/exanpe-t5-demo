package fr.exanpe.t5.demo.pages;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;

/**
 * Start page of application exanpe-t5-demo.
 */
public class Index
{
    private static final String GAE_HOSTNAME = "appspot.com";

    @Property
    @Parameter(value = "asset:context:img/new.jpg")
    private Asset neww;

    @Inject
    private Request request;

    public Boolean getIsGae()
    {
        return request.getServerName().contains(GAE_HOSTNAME);
    }
}
