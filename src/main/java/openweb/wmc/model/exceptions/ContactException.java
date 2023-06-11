package openweb.wmc.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContactException extends RuntimeException {

	private static final long serialVersionUID = 1L;
			
	public ContactException(String id) {
		super(id);
	}
}
