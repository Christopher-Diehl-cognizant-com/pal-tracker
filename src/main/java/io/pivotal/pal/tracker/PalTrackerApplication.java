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
	 * @param dataSource
	 * @return
	 */
	@Bean
	public TimeEntryRepository timeEntryRepository(DataSource dataSource){
		return new JdbcTimeEntryRepository(dataSource);
	}
}
