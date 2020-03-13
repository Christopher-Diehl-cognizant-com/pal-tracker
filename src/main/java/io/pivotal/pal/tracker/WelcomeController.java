package io.pivotal.pal.tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 780449
 */
@RestController
public class WelcomeController{
	@GetMapping("/")
	public String sayHello(){
		return "hello";
	}
}
