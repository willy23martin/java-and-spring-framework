package openweb.wmc.controllers.errors;

import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

@Component
public class ApiErrorDefaultErrorAttributes extends DefaultErrorAttributes {

	
	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
		// TODO
		return super.getErrorAttributes(webRequest, options);
	}
	
}
