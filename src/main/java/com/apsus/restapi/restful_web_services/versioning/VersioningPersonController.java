package com.apsus.restapi.restful_web_services.versioning;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	@GetMapping("v1/person")
	public Person getFirstVersionOfPerson() {
		return new PersonV1("Eduardo Ruiz");
	}

	@GetMapping("v2/person")
	public Person getSecondVersionOfPerson() {

		return new PersonV2(new Name("Eduardo", "Ruiz"));
	}
}
