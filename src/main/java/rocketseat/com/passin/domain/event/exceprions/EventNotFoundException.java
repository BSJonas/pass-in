package rocketseat.com.passin.domain.event.exceprions;

public class EventNotFoundException extends RuntimeException{

	public EventNotFoundException(String message){
		super(message);
	}
}
