package fr.exanpe.t5.demo.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;

@Import(stylesheet="context:css/github.css", library={"context:js/highlight.js", "context:js/exanpe-demo.js"})
public class HighlightBody {

	@Property
	@Parameter(defaultPrefix = BindingConstants.LITERAL, required = true, allowNull = false, value="xml")
	private String type;


}
