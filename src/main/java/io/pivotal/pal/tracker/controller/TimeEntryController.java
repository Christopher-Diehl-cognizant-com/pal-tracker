package io.pivotal.pal.tracker.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;
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
	private final DistributionSummary timeEntrySummary;
	private final Counter actionCounter;

	/**
	 *
	 * @param timeEntriesRepo
	 * @param meterRegistry
	 */
//	public TimeEntryController(TimeEntryRepository timeEntryRepository){
//		this.timeEntryRepository = timeEntryRepository;
//	}
	public TimeEntryController(TimeEntryRepository timeEntriesRepo, MeterRegistry meterRegistry
	){
		this.timeEntryRepository = timeEntriesRepo;

		timeEntrySummary = meterRegistry.summary("timeEntry.summary");
		actionCounter = meterRegistry.counter("timeEntry.actionCounter");
	}

	/**
	 *
	 * @param timeEntry
	 * @return
	 */
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry){
		TimeEntry createdTimeEntry = timeEntryRepository.create(timeEntry);
		actionCounter.increment();
		timeEntrySummary.record(timeEntryRepository.list().size());
		return new ResponseEntity<>(createdTimeEntry, HttpStatus.CREATED);
	}

	/**
	 *
	 * @param timeEntryId
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<TimeEntry> read(@PathVariable(name = "id") Long timeEntryId){
		TimeEntry timeEntry = timeEntryRepository.find(timeEntryId);
		if(timeEntry != null){
			actionCounter.increment();
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return new ResponseEntity<>(timeEntry, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 *
	 * @return
	 */
	@GetMapping()
	public ResponseEntity<List<TimeEntry>> list(){
		actionCounter.increment();
		return new ResponseEntity<>(timeEntryRepository.list(), HttpStatus.OK);
	}

	/**
	 *
	 * @param timeEntryId
	 * @param timeEntry
	 * @return
	 */
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TimeEntry> update(@PathVariable(name = "id") Long timeEntryId, @RequestBody TimeEntry timeEntry){
		TimeEntry updatedTimeEntry = timeEntryRepository.update(timeEntryId, timeEntry);
		if(updatedTimeEntry != null){
			actionCounter.increment();
			return new ResponseEntity<>(updatedTimeEntry, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 *
	 * @param timeEntryId
	 * @return
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity delete(@PathVariable(name = "id") long timeEntryId){
		timeEntryRepository.delete(timeEntryId);
		actionCounter.increment();
		timeEntrySummary.record(this.timeEntryRepository.list().size());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
