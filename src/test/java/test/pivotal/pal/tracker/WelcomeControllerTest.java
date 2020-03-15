package test.pivotal.pal.tracker;

import io.pivotal.pal.tracker.controller.WelcomeController;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 *
 * @author 780449
 */
public class WelcomeControllerTest{
	@Test
	public void itSaysHello() throws Exception{
		WelcomeController controller = new WelcomeController("A welcome message");

		assertThat(controller.sayHello()).isEqualTo("A welcome message");
	}
}
