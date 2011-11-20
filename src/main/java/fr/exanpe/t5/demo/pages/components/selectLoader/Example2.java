package fr.exanpe.t5.demo.pages.components.selectLoader;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.tapestry5.OptionModel;
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
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.SelectModelFactory;

import fr.exanpe.t5.demo.data.City;
import fr.exanpe.t5.demo.data.Country;
import fr.exanpe.t5.demo.data.ThirdEnum;
import fr.exanpe.t5.demo.encoders.CityEncoder;
import fr.exanpe.t5.demo.encoders.CountryEncoder;
import fr.exanpe.t5.demo.services.DataService;
import fr.exanpe.t5.lib.constants.ExanpeEventConstants;

public class Example2
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

    @Property
    private SelectModel typeModel;

    @Property
    @Persist(PersistenceConstants.FLASH)
    private String typeValue;

    @Inject
    private Request request;

    @SetupRender
    public void ini()
    {
        // invoke my service to find all countries, e.g. in the database
        List<Country> countries = dataService.getCountryList();

        // create a SelectModel from my list of countries
        countryModel = selectModelFactory.create(countries, "name");

        // load city and type select
        loadCitySelect();
        loadTypeSelect();
    }

    private void loadCitySelect()
    {
        if (countryValue == null)
            cityModel = new SelectModelImpl(new OptionModelImpl[0]);
        else
            cityModel = populateCitySelect(countryValue.getId());
    }

    private void loadTypeSelect()
    {
        if (cityValue == null)
            typeModel = new SelectModelImpl(new OptionModelImpl[0]);
        else
        {
            List<OptionModel> opts = createTypeOpt(cityValue.toString());
            OptionModel[] om = new OptionModel[opts.size()];
            typeModel = new SelectModelImpl((OptionModel[]) opts.toArray(om));
        }
    }

    @OnEvent(value = ExanpeEventConstants.SELECTLOADER_EVENT, component = "country")
    public SelectModel populateCitySelect(String value)
    {
        if (StringUtils.isEmpty(value))
            return null;

        cityModel = selectModelFactory.create(dataService.getCitiesByCountry(value), "name");
        if (request.isXHR())
        {
            cityModel.getOptions().add(0, new OptionModelImpl("", new City("", "")));
        }
        return cityModel;
    }

    @OnEvent(value = ExanpeEventConstants.SELECTLOADER_EVENT, component = "city")
    public SelectModel populateSelectType(String value)
    {
        List<OptionModel> opts = createTypeOpt(value);

        OptionModel[] om = new OptionModel[opts.size()];

        return new SelectModelImpl((OptionModel[]) opts.toArray(om));
    }

    private List<OptionModel> createTypeOpt(String value)
    {
        if (StringUtils.isEmpty(value))
            return null;

        ThirdEnum[] te = ThirdEnum.values();

        List<OptionModel> opts = new ArrayList<OptionModel>(3);

        for (int i = 0; i < te.length; i++)
            opts.add(new OptionModelImpl(te[i].toString()));

        return opts;
    }

    public ValueEncoder<Country> getCountryEncoder()
    {
        return new CountryEncoder(dataService);
    }

    public ValueEncoder<City> getCityEncoder()
    {
        return new CityEncoder(dataService);
    }
}
