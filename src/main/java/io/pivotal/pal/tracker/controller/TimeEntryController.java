package io.pivotal.pal.tracker.controller;

import io.pivotal.pal.tracker.TimeEntryRepository;
import io.pivotal.pal.tracker.model.TimeEntry;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 780449
 */
@RestController
@RequestMapping("/time-entries")
public class TimeEntryController{
	private TimeEntryRepository timeEntryRepository;

	/**
	 *
	 * @param timeEntryRepository
	 */
	public TimeEntryController(TimeEntryRepository timeEntryRepository){
		this.timeEntryRepository = timeEntryRepository;
	}

	/**
	 *
	 * @param timeEntry
	 * @return
	 */
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity create(@RequestBody TimeEntry timeEntry){
		TimeEntry createdTimeEntry = timeEntryRepository.create(timeEntry);
		return new ResponseEntity<>(createdTimeEntry, HttpStatus.CREATED);
	}

	/**
	 *
	 * @param timeEntryId
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<TimeEntry> read(@PathVariable(name = "id") long timeEntryId){
		TimeEntry readTimeEntry = timeEntryRepository.find(timeEntryId);
		if(readTimeEntry == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(readTimeEntry, HttpStatus.OK);
	}

	/**
	 *
	 * @return
	 */
	@GetMapping()
	public ResponseEntity<List<TimeEntry>> list(){
		List<TimeEntry> timeEntryList = timeEntryRepository.list();
		return new ResponseEntity<>(timeEntryList, HttpStatus.OK);
	}

	/**
	 *
	 * @param timeEntryId
	 * @param timeEntry
	 * @return
	 */
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity update(@PathVariable(name = "id") long timeEntryId, @RequestBody TimeEntry timeEntry){
		TimeEntry updatedTimeEntry = timeEntryRepository.update(timeEntryId, timeEntry);
		if(updatedTimeEntry == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(updatedTimeEntry, HttpStatus.OK);
	}

	/**
	 *
	 * @param timeEntryId
	 * @return
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity delete(@PathVariable(name = "id") long timeEntryId){
		timeEntryRepository.delete(timeEntryId);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
