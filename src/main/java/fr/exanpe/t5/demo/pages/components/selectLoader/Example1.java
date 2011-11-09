package fr.exanpe.t5.demo.pages.components.selectLoader;

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
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.util.EnumSelectModel;
import org.apache.tapestry5.util.EnumValueEncoder;

import fr.exanpe.t5.demo.data.CountryEnum;
import fr.exanpe.t5.demo.services.DataService;
import fr.exanpe.t5.lib.constants.ExanpeEventConstants;

public class Example1
{
    @Inject
    private DataService dataService;

    @Inject
    private Messages messages;

    @Property
    private ValueEncoder<CountryEnum> countryEncoder = new EnumValueEncoder(CountryEnum.class);

    @Property
    private SelectModel country;

    @Property
    @Persist(PersistenceConstants.FLASH)
    private CountryEnum countryValue;

    @Property
    private SelectModel city;

    @Property
    @Persist(PersistenceConstants.FLASH)
    private String cityValue;

    @SetupRender
    public void ini()
    {
        country = new EnumSelectModel(CountryEnum.class, messages);
        loadCountrySelect();
    }

    public void onSubmit()
    {
        loadCountrySelect();
    }

    private void loadCountrySelect()
    {
        if (countryValue == null)
            city = new SelectModelImpl(new OptionModelImpl[0]);
        else
            city = populateSelect(countryValue.toString());
    }

    @OnEvent(value = ExanpeEventConstants.SELECTLOADER_EVENT)
    public SelectModel populateSelect(String value)
    {
        if (StringUtils.isEmpty(value))
            return null;

        String[] cities = dataService.getCitiesFromCountry(CountryEnum.valueOf(value));

        OptionModel[] om = new OptionModel[cities.length];

        for (int i = 0; i < cities.length; i++)
            om[i] = new OptionModelImpl(cities[i]);

        city = new SelectModelImpl(om);

        return city;
    }
}
