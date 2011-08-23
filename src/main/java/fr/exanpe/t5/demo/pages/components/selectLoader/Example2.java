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
import org.apache.tapestry5.internal.services.EnumValueEncoderFactory;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.util.EnumSelectModel;

import fr.exanpe.t5.demo.data.CountryEnum;
import fr.exanpe.t5.demo.data.ThirdEnum;
import fr.exanpe.t5.demo.services.DataService;
import fr.exanpe.t5.lib.constants.ExanpeEventConstants;

public class Example2
{
    @Inject
    private DataService dataService;

    @Inject
    private Messages messages;

    @Property
    private ValueEncoder<CountryEnum> countryEncoder = new EnumValueEncoderFactory().create(CountryEnum.class);

    @Property
    private SelectModel country;

    @Property
    private SelectModel city;

    @Property
    private SelectModel type;

    @Property
    @Persist(PersistenceConstants.FLASH)
    private CountryEnum countryValue;

    @Property
    @Persist(PersistenceConstants.FLASH)
    private String cityValue;

    @Property
    @Persist(PersistenceConstants.FLASH)
    private String typeValue;

    @SetupRender
    public void ini()
    {
        country = new EnumSelectModel(CountryEnum.class, messages);
        loadCitySelect();
        loadTypeSelect();

    }

    private void loadCitySelect()
    {
        if (countryValue == null)
            city = new SelectModelImpl(new OptionModelImpl[0]);
        else
        {
            List<OptionModel> opts = createCityOpt(countryValue.toString());
            OptionModel[] om = new OptionModel[opts.size()];
            city = new SelectModelImpl((OptionModel[]) opts.toArray(om));
        }
    }

    private void loadTypeSelect()
    {
        if (cityValue == null)
            type = new SelectModelImpl(new OptionModelImpl[0]);
        else
        {
            List<OptionModel> opts = createTypeOpt(cityValue.toString());
            OptionModel[] om = new OptionModel[opts.size()];
            type = new SelectModelImpl((OptionModel[]) opts.toArray(om));
        }
    }

    public void onSubmit()
    {

    }

    private List<OptionModel> createCityOpt(String value)
    {
        if (StringUtils.isEmpty(value))
            return null;

        List<OptionModel> opts = new ArrayList<OptionModel>();

        String[] cities = dataService.getCitiesFromCountry(CountryEnum.valueOf(value));

        for (int i = 0; i < cities.length; i++)
            opts.add(new OptionModelImpl(cities[i]));

        return opts;
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

    @OnEvent(value = ExanpeEventConstants.SELECTLOADER_EVENT, component = "country")
    public SelectModel populateSelectCity(String value)
    {
        List<OptionModel> opts = createCityOpt(value);
        opts.add(0, new OptionModelImpl(" ", " "));

        OptionModel[] om = new OptionModel[opts.size()];

        return new SelectModelImpl((OptionModel[]) opts.toArray(om));
    }

    @OnEvent(value = ExanpeEventConstants.SELECTLOADER_EVENT, component = "city")
    public SelectModel populateSelectType(String value)
    {
        List<OptionModel> opts = createTypeOpt(value);

        OptionModel[] om = new OptionModel[opts.size()];

        return new SelectModelImpl((OptionModel[]) opts.toArray(om));
    }
}
