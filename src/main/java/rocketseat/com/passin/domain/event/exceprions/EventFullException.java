package rocketseat.com.passin.domain.event.exceprions;

public class EventFullException extends RuntimeException{
	public EventFullException(String message){
		super(message);
	}
}
