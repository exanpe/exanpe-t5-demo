package fr.exanpe.t5.demo.pages.components.ajaxLoader;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.tapestry5.annotations.Property;

public class Example4
{

    @Property
    private String date;

    public void onActivate()
    {
        date = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(new Date());
    }

}
