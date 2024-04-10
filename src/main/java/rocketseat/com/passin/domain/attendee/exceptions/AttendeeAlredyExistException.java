package rocketseat.com.passin.domain.attendee.exceptions;

public class AttendeeAlredyExistException extends RuntimeException{
	public AttendeeAlredyExistException (String message){
		super(message);
	}
}
