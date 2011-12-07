package fr.exanpe.t5.demo.pages.components.authorize;

import fr.exanpe.t5.demo.base.BaseAuthorize;
import fr.exanpe.t5.lib.annotation.Authorize;

@Authorize(any =
{ "ROLE_ADMIN", "ROLE_USER" })
public class Example5User extends BaseAuthorize
{

}
