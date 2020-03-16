package io.pivotal.pal.tracker.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 780449
 */
@RestController
public class WelcomeController{

	private String helloMessage;

	/**
	 *
	 * @param helloMessage
	 */
	public WelcomeController(@Value("${welcome.message}") String helloMessage){
		this.helloMessage = helloMessage;
	}

	/**
	 *
	 * @return
	 */
	@GetMapping("/")
	public String sayHello(){
//		return "hello";
		return this.helloMessage;
	}
}
