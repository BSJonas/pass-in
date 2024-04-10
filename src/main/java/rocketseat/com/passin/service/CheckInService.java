package rocketseat.com.passin.service;

import java.time.LocalDateTime;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rocketseat.com.passin.domain.attendee.Attendee;
import rocketseat.com.passin.domain.checkin.CheckIn;
import rocketseat.com.passin.domain.checkin.exceptions.CheckInAlreadyExistsException;
import rocketseat.com.passin.repositories.CheckinRepository;

@Service
@RequiredArgsConstructor
public class CheckInService {
	private final CheckinRepository checkinRepository;

	public void registerCheckIn(Attendee attendee){
		this.VerifyCheckInExists(attendee.getId());

		CheckIn newCheckIn = new CheckIn();
		newCheckIn.setAttendee(attendee);
		newCheckIn.setCreatedAt(LocalDateTime.now());

		this.checkinRepository.save(newCheckIn);
	}

	private void VerifyCheckInExists(String attendId){
		Optional<CheckIn> isCheckedIn = this.getCheckIn(attendId);
		if (isCheckedIn.isPresent()) throw new CheckInAlreadyExistsException("Attendee already checked in");
	}

	public Optional<CheckIn> getCheckIn(String attendeeId) {
		return this.checkinRepository.findByAttendeeId(attendeeId);
	}
}
