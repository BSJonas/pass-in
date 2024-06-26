package rocketseat.com.passin.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rocketseat.com.passin.domain.event.exceprions.EventNotFoundException;

@ControllerAdvice
public class ExceptionEntityHandler {

	@ExceptionHandler(EventNotFoundException.class)
	public ResponseEntity handlesEventNotFound(EventNotFoundException exception){
		return ResponseEntity.notFound().build();
	}
}
