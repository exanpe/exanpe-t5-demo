package fr.exanpe.t5.demo.pages.components.ajaxLoader;

public class Example2
{

    public String getSleep()
    {
        try
        {
            Thread.currentThread().sleep(2000);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "";
    }

}
