package fr.exanpe.t5.demo.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

/**
 * Layout component for pages of application exanpe-t5-demo.
 */
@Import(stylesheet="context:layout/layout.css")
public class ComponentDemoLayout
{

	@Property
	@Parameter(required = true, allowNull = false, defaultPrefix = BindingConstants.LITERAL)
	private String title;
	
    @Property
    @Parameter
    private Block description;
    
    @Property
    @Parameter
    private Block code;
    
    @Property
    @Parameter
    private Block javacode;
    
    @Property
    @Parameter
    private Block notice;
    
    @Inject
    private JavaScriptSupport javaScriptSupport;

}
