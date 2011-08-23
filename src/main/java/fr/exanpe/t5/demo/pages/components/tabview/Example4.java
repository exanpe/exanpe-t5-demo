package fr.exanpe.t5.demo.pages.components.tabview;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;

import fr.exanpe.t5.lib.components.TabView;

public class Example4
{
    @Component(id = "tabv")
    private TabView tabView;

    @Property
    private String defaultTab = "tab2";

    public void onActionFromSetThird()
    {
        tabView.setSelectedTab("tab3");
    }
}
