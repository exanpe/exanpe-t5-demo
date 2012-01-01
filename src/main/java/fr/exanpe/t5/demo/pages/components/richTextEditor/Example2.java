package fr.exanpe.t5.demo.pages.components.richTextEditor;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

public class Example2
{
    @Persist(PersistenceConstants.FLASH)
    @Property
    private String rte;

    @Inject
    @Property
    private Messages messages;
}
