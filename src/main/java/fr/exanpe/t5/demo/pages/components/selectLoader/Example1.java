package fr.exanpe.t5.demo.pages.components.selectLoader;

import java.util.List;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.internal.OptionModelImpl;
import org.apache.tapestry5.internal.SelectModelImpl;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.SelectModelFactory;

import fr.exanpe.t5.demo.data.City;
import fr.exanpe.t5.demo.data.Country;
import fr.exanpe.t5.demo.encoders.CountryEncoder;
import fr.exanpe.t5.demo.services.DataService;
import fr.exanpe.t5.lib.constants.ExanpeEventConstants;

public class Example1
{
    @Inject
    private SelectModelFactory selectModelFactory;

    @Property
    private SelectModel countryModel;

    @Property
    @Persist(PersistenceConstants.FLASH)
    private Country countryValue;

    @Property
    private SelectModel cityModel;

    @Property
    @Persist(PersistenceConstants.FLASH)
    private City cityValue;

    @Inject
    private DataService dataService;

    @SetupRender
    public void ini()
    {
        // invoke my service to find all countries, e.g. in the database
        List<Country> countries = dataService.getCountryList();

        // create a SelectModel from my list of countries
        countryModel = selectModelFactory.create(countries, "name");

        // init cityModel
        loadCitySelect();
    }

    @OnEvent(value = ExanpeEventConstants.SELECTLOADER_EVENT)
    public SelectModel populateSelect(String value)
    {
        cityModel = selectModelFactory.create(dataService.getCitiesByCountry(value), "name");
        return cityModel;
    }

    private void loadCitySelect()
    {
        if (countryValue == null)
            cityModel = new SelectModelImpl(new OptionModelImpl[0]);
        else
            cityModel = populateSelect(countryValue.getId());
    }

    public ValueEncoder<Country> getCountryEncoder()
    {
        return new CountryEncoder(dataService);
    }
}
