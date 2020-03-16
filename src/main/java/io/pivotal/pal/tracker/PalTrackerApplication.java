package io.pivotal.pal.tracker;

import javax.sql.DataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author 780449
 */
@SpringBootApplication
public class PalTrackerApplication{

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args){
		SpringApplication.run(PalTrackerApplication.class, args);
	}

	/**
	 *
	 * @return
	 */
	@Bean
//	public TimeEntryRepository timeEntryRepository(DataSource dataSource){
	public TimeEntryRepository timeEntryRepository(){
//        return new JdbcTimeEntryRepository(dataSource);
		return new InMemoryTimeEntryRepository();
	}
}
