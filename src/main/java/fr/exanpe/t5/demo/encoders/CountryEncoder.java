package fr.exanpe.t5.demo.encoders;

import org.apache.tapestry5.ValueEncoder;

import fr.exanpe.t5.demo.data.Country;
import fr.exanpe.t5.demo.services.DataService;

/**
 * Encoder for {@link Country} objects
 * 
 * @author lguerin
 */
public class CountryEncoder implements ValueEncoder<Country>
{

    private DataService dataService;

    public CountryEncoder(DataService dataService)
    {
        this.dataService = dataService;
    }

    public String toClient(Country value)
    {
        return String.valueOf(value.getId());
    }

    public Country toValue(String clientValue)
    {
        if (clientValue != null && !"".equalsIgnoreCase(clientValue)) { return dataService.findCountryById(clientValue); }
        return null;
    }

}
