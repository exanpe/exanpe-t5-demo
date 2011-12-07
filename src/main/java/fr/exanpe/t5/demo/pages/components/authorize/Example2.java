package fr.exanpe.t5.demo.pages.components.authorize;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import fr.exanpe.t5.demo.base.BaseAuthorize;

public class Example2 extends BaseAuthorize
{
    @Inject
    @Property
    private Block userBlockAction;

    @Inject
    @Property
    private Block adminBlockAction;

}
