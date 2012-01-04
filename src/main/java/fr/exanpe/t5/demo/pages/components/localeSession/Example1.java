package fr.exanpe.t5.demo.pages.components.localeSession;

import java.util.Locale;

import org.apache.tapestry5.ioc.annotations.Inject;

import fr.exanpe.t5.lib.services.LocaleSessionService;

public class Example1
{
    @Inject
    private LocaleSessionService localeSessionService;

    void onActionFromFr()
    {
        localeSessionService.setLocale(Locale.FRANCE);
    }

    void onActionFromEn()
    {
        localeSessionService.setLocale("en");
    }
}
