package com.apsus.restapi.restful_web_services.versioning;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("/person")
	public Person getPerson(@RequestParam String version) {
		return switch (version) {
			case "1" -> new PersonV1("Eduardo Ruiz");
			case "2" -> new PersonV2(new Name("Eduardo", "Ruiz"));
			default -> throw new IllegalArgumentException("Version not supported");
		};
	}

	@GetMapping(path = "/person-header")
	public Person getPersonByHeader(@RequestHeader("X-API-VERSION") String version) {
		return switch (version) {
			case "1" -> new PersonV1("Eduardo Ruiz");
			case "2" -> new PersonV2(new Name("Eduardo", "Ruiz"));
			default -> throw new IllegalArgumentException("Version not supported");
		};
	}
}
