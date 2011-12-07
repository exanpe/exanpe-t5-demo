package fr.exanpe.t5.demo.pages.components.authorize;

import fr.exanpe.t5.demo.base.BaseAuthorize;
import fr.exanpe.t5.lib.annotation.Authorize;

@Authorize(any = "ROLE_ADMIN")
public class Example5Admin extends BaseAuthorize
{

}
