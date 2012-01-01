package fr.exanpe.t5.demo.pages.components.richTextEditor;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

public class Example1
{
    @Persist(PersistenceConstants.FLASH)
    @Property
    private String rte;
}
