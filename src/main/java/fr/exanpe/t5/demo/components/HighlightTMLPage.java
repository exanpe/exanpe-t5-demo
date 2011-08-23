package fr.exanpe.t5.demo.components;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.RequestGlobals;

@Import(stylesheet="context:css/github.css", library={"context:js/highlight.js", "context:js/exanpe-demo.js"})
public class HighlightTMLPage {
	
	@Property
	@Parameter(defaultPrefix = BindingConstants.LITERAL, required = true, allowNull = false, value="<p:code>")
	private String codeStart;
	
	@Property
	@Parameter(defaultPrefix = BindingConstants.LITERAL, required = true, allowNull = false, value="</p:code>")
	private String codeEnd;
	
	@Property
	private String highlight;
	
	@Inject
	private RequestGlobals request;
	
	@SetupRender
	public void init() throws IOException{		
		InputStream stream = request.getHTTPServletRequest().getSession().getServletContext().getResourceAsStream("/"+request.getActivePageName()+".tml");
		
		String s = IOUtils.toString(stream);
		
		int start = s.indexOf(codeStart);
		if(start == -1)
			throw new IllegalStateException("The hightlight component requires a "+codeStart+" tag in the calling page");
		
		highlight = s.substring(start+codeStart.length(), s.indexOf(codeEnd));
	}

}
