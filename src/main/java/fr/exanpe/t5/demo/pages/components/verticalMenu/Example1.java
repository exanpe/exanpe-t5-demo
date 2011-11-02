package fr.exanpe.t5.demo.pages.components.verticalMenu;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;

import fr.exanpe.t5.lib.components.VerticalMenu;
import fr.exanpe.t5.lib.constants.ExanpeEventConstants;

public class Example1
{
    @Inject
    private PageRenderLinkSource pageLinkSource;

    @InjectComponent
    private VerticalMenu verticalMenu;

    @OnEvent(ExanpeEventConstants.VERTICALMENU_EVENT)
    Object handleSelectMenu(String menuId)
    {
        if ("external".equals(menuId))
        {
            URL external = null;
            try
            {
                external = new URL("http://www.google.fr");
            }
            catch (MalformedURLException ex)
            {
                throw new RuntimeException(ex);
            }
            verticalMenu.resetSelectedMenuItem();
            return external;
        }
        if ("example1".equals(menuId)) { return pageLinkSource.createPageRenderLink(Example1.class); }
        return this;
    }
}
