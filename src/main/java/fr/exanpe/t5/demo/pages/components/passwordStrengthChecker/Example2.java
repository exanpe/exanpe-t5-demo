package fr.exanpe.t5.demo.pages.components.passwordStrengthChecker;

import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;

import fr.exanpe.t5.lib.constants.ExanpeEventConstants;
import fr.exanpe.t5.lib.constants.PasswordStrengthCheckerTypeEnum;

public class Example2
{
    @Property
    private String password;

    @OnEvent(value = ExanpeEventConstants.PASSWORDSTRENGTHCHECKER_EVENT)
    PasswordStrengthCheckerTypeEnum dummyChecker(String pwd)
    {
        Integer size = pwd.length();
        PasswordStrengthCheckerTypeEnum result = PasswordStrengthCheckerTypeEnum.VERYWEAK;
        if (size >= 3)
        {
            result = PasswordStrengthCheckerTypeEnum.WEAK;
        }
        if (size >= 4)
        {
            result = PasswordStrengthCheckerTypeEnum.STRONG;
        }
        if (size >= 5)
        {
            result = PasswordStrengthCheckerTypeEnum.STRONGEST;
        }
        return result;
    }
}
