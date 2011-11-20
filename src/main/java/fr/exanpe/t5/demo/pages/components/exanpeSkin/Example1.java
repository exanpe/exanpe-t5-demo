package fr.exanpe.t5.demo.pages.components.exanpeSkin;

import java.util.List;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.SelectModelFactory;

import fr.exanpe.t5.demo.data.Country;
import fr.exanpe.t5.demo.data.User;
import fr.exanpe.t5.demo.encoders.CountryEncoder;
import fr.exanpe.t5.demo.services.DataService;

@Import(stylesheet = "${exanpe.asset-base}/css/exanpe-t5-lib-skin.css")
public class Example1
{
    @Inject
    private DataService dataService;

    @Inject
    private Messages messages;

    /** GRID **/
    @Property
    private List<User> users;

    @Property
    private User iteUser;

    /** Auto Complete **/
    @Property
    private String country;

    public List<String> onProvideCompletionsFromCountryName(String partial)
    {
        return dataService.getListOfString();
    }

    /** Palette **/

    @Inject
    private SelectModelFactory selectModelFactory;

    @Property
    private SelectModel countryModel;

    public ValueEncoder<Country> getCountryEncoder()
    {
        return new CountryEncoder(dataService);
    }

    @Property
    private List<Country> selected;

    /** BeanEditor */
    @Property
    private User userEdit;

    @SetupRender
    public void init()
    {
        // list of users
        users = dataService.getListUsers();

        // invoke my service to find all countries, e.g. in the database
        List<Country> countries = dataService.getCountryList();

        // create a SelectModel from my list of countries
        countryModel = selectModelFactory.create(countries, "name");
    }
}
