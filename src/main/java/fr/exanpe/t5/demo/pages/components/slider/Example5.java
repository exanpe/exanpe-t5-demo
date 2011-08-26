package fr.exanpe.t5.demo.pages.components.slider;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;

import fr.exanpe.t5.lib.constants.ExanpeEventConstants;

public class Example5
{
    @Property
    @Persist
    private int sliderValue;

    @InjectComponent
    private Zone zone;

    @OnEvent(ExanpeEventConstants.SLIDER_EVENT)
    Object handleSliderAjaxEvent(String value)
    {
        return zone.getBody();
    }
}
