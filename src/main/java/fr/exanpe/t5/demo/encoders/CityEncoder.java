package fr.exanpe.t5.demo.encoders;

import org.apache.tapestry5.ValueEncoder;

import fr.exanpe.t5.demo.data.City;
import fr.exanpe.t5.demo.services.DataService;

/**
 * Encoder for {@link City} objects
 * 
 * @author lguerin
 */
public class CityEncoder implements ValueEncoder<City>
{

    private DataService dataService;

    public CityEncoder(DataService dataService)
    {
        this.dataService = dataService;
    }

    public String toClient(City value)
    {
        if (value == null || "".equalsIgnoreCase(value.getId()))
            return "";
        return String.valueOf(value.getId());
    }

    public City toValue(String clientValue)
    {
        if (clientValue != null && !"".equalsIgnoreCase(clientValue)) { return dataService.findCityById(clientValue); }
        return null;
    }

}
