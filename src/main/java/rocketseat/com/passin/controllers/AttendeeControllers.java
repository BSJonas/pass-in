package rocketseat.com.passin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import rocketseat.com.passin.dto.attendee.AttendeeBadgeDTO;
import rocketseat.com.passin.dto.attendee.AttendeeBadgeResponseDTO;
import rocketseat.com.passin.service.AttendeeService;
import rocketseat.com.passin.service.CheckInService;

@RestController
@RequestMapping("/attendees")
@RequiredArgsConstructor
public class AttendeeControllers {
	private final AttendeeService attendeeService;

	@GetMapping("/{attendeeId}/badge")
	public ResponseEntity<AttendeeBadgeResponseDTO> getAttendeeBadge(@PathVariable String attendeeId, UriComponentsBuilder uriComponentsBuilder){
		AttendeeBadgeResponseDTO response = this.attendeeService.getAttendeeBadge(attendeeId,uriComponentsBuilder);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/{attendeeId}/check-in")
	public ResponseEntity<Object> registerCheckIn(@PathVariable String attendeeId, UriComponentsBuilder uriComponentsBuilder) {

		this.attendeeService.checkInAttendee(attendeeId);
		var uri = uriComponentsBuilder.path("/attendees/{attendeeId}/badge").buildAndExpand(attendeeId).toUri();
		return ResponseEntity.created(uri).build();
	}
}
