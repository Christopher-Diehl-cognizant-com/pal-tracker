package io.pivotal.pal.tracker;

import io.pivotal.pal.tracker.model.TimeEntry;
import java.util.List;

/**
 *
 * @author 780449
 */
public interface TimeEntryRepository{

	/**
	 *
	 * @param any
	 * @return
	 */
	public TimeEntry create(TimeEntry any);

	/**
	 *
	 * @param timeEntryId
	 * @return
	 */
	public TimeEntry find(Long timeEntryId);

	/**
	 *
	 * @return
	 */
	public List<TimeEntry> list();

	/**
	 *
	 * @param eq
	 * @param any
	 * @return
	 */
	public TimeEntry update(Long eq, TimeEntry any);

	/**
	 *
	 * @param timeEntryId
	 */
	public void delete(Long timeEntryId);
}
