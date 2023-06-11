package openweb.wmc.model.exceptions.errors;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ApiError {

	private HttpStatus status;

	private LocalDateTime date;

	private String message;

	public ApiError() {

	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
