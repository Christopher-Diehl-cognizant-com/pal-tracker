package io.pivotal.pal.tracker.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author 780449
 */
public class TimeEntry{
	private long id;
	private long projectId;
	private long userId;
	private LocalDate date;
	private int hours;

	/**
	 *
	 */
	public TimeEntry(){
	}

	/**
	 *
	 * @param l
	 * @param l1
	 * @param i
	 * @param l2
	 * @param ld
	 */
	public TimeEntry(long id, long projectId, long userId, LocalDate date, int hours){
		this.id = id;
		this.projectId = projectId;
		this.userId = userId;
		this.date = date;
		this.hours = hours;
	}

	/**
	 *
	 * @param l
	 * @param l1
	 * @param ld
	 * @param i
	 */
	public TimeEntry(long projectId, long userId, LocalDate date, int hours){
		this.projectId = projectId;
		this.userId = userId;
		this.date = date;
		this.hours = hours;
	}

	/**
	 *
	 * @return
	 */
	public long getId(){
		return id;
	}

	/**
	 *
	 * @param id
	 */
	public void setId(long id){
		this.id = id;
	}

	/**
	 *
	 * @return
	 */
	public long getProjectId(){
		return projectId;
	}

	/**
	 *
	 * @param projectId
	 */
	public void setProjectId(long projectId){
		this.projectId = projectId;
	}

	/**
	 *
	 * @return
	 */
	public long getUserId(){
		return userId;
	}

	/**
	 *
	 * @param userId
	 */
	public void setUserId(long userId){
		this.userId = userId;
	}

	/**
	 *
	 * @return
	 */
	public LocalDate getDate(){
		return date;
	}

	/**
	 *
	 * @param date
	 */
	public void setDate(LocalDate date){
		this.date = date;
	}

	/**
	 *
	 * @return
	 */
	public int getHours(){
		return hours;
	}

	/**
	 *
	 * @param hours
	 */
	public void setHours(int hours){
		this.hours = hours;
	}

	@Override
	public String toString(){
		return "TimeEntry{"
			+ "id=" + id
			+ ", projectId=" + projectId
			+ ", userId=" + userId
			+ ", date=" + date
			+ ", hours=" + hours
			+ '}';
	}

	@Override
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		if(!(obj instanceof TimeEntry)){
			return false;
		}
		TimeEntry timeEntry = (TimeEntry) obj;
		return getId() == timeEntry.getId()
			&& getProjectId() == timeEntry.getProjectId()
			&& getUserId() == timeEntry.getUserId()
			&& getHours() == timeEntry.getHours()
			&& Objects.equals(getDate(), timeEntry.getDate());
	}

	@Override
	public int hashCode(){
		return Objects.hash(getId(), getProjectId(), getUserId(), getDate(), getHours());
	}

}
