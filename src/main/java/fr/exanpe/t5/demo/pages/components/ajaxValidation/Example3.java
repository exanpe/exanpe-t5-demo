package fr.exanpe.t5.demo.pages.components.ajaxValidation;

import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;

import fr.exanpe.t5.lib.constants.AjaxValidationResult;
import fr.exanpe.t5.lib.constants.ExanpeEventConstants;

public class Example3
{
    @Property
    private String loginValue;

    @OnEvent(value = ExanpeEventConstants.AJAXVALIDATION_EVENT, component = "login")
    public AjaxValidationResult validateLogin(String login)
    {
        if (login != null && login.length() < 7)
            return AjaxValidationResult.TRUE;

        return AjaxValidationResult.FALSE;
    }
}
