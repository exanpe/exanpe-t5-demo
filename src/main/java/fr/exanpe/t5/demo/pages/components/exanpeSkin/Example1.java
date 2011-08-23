package fr.exanpe.t5.demo.pages.components.exanpeSkin;

import java.util.List;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.util.EnumSelectModel;
import org.apache.tapestry5.util.EnumValueEncoder;

import fr.exanpe.t5.demo.data.User;
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

    @Property
    private final ValueEncoder<PaletteEnum> encoder = new EnumValueEncoder(PaletteEnum.class);

    @Property
    private final SelectModel model = new EnumSelectModel(PaletteEnum.class, messages);

    @Property
    private List<PaletteEnum> selected;

    public enum PaletteEnum
    {
        TEST, TEST2, TEST3, TEST4;
    }

    /** BeanEditor */
    @Property
    private User userEdit;

    @SetupRender
    public void init()
    {
        users = dataService.getListUsers();
    }
}
