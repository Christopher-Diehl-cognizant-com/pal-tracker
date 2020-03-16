package io.pivotal.pal.tracker;

import io.pivotal.pal.tracker.model.TimeEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 780449
 */
public class InMemoryTimeEntryRepository implements TimeEntryRepository{
	private long currentTimeId = 0L;
	private final Map<Long, TimeEntry> inMemoryDataBase = new HashMap<>();

	/**
	 *
	 * @param timeEntry
	 * @return
	 */
	public TimeEntry create(TimeEntry timeEntry){
		TimeEntry entry = new TimeEntry(++currentTimeId, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
		inMemoryDataBase.put(currentTimeId, entry);
		return entry;
	}

	/**
	 *
	 * @param id
	 * @return
	 */
	public TimeEntry find(Long id){

		return inMemoryDataBase.get(id);

	}

	/**
	 *
	 * @return
	 */
	public List<TimeEntry> list(){

		return new ArrayList<TimeEntry>(inMemoryDataBase.values());

	}

	/**
	 *
	 * @param id
	 * @param timeEntry
	 * @return
	 */
	public TimeEntry update(Long id, TimeEntry timeEntry){

		TimeEntry entry = inMemoryDataBase.get(id);

		if(entry == null){
			return null;
		}
		entry.setProjectId(timeEntry.getProjectId());
		entry.setUserId(timeEntry.getUserId());
		entry.setDate(timeEntry.getDate());
		entry.setHours(timeEntry.getHours());
		return entry;
	}

	/**
	 *
	 * @param id
	 */
	public void delete(Long id){
		inMemoryDataBase.remove(id);
	}
}
