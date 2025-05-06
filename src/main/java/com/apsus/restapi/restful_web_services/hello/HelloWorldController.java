package com.apsus.restapi.restful_web_services.hello;


import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

	private MessageSource messageSource;

	public HelloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@GetMapping()
	public String hello() {
		return "Hello World";
	}

	@GetMapping(path = "/international")
	public String helloInternational() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
	}

	@GetMapping(path = "/bean")
	public HelloWorldBean helloBean() {
		return new HelloWorldBean("Hello World");
	}

	@GetMapping(path = "/bean/{name}")
	public HelloWorldBean helloBean(@PathVariable String name) {
		return new HelloWorldBean("Hello World " + name);
	}
}
