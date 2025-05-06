package com.apsus.restapi.restful_web_services.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FilterController {

	@GetMapping("filter")
	public MappingJacksonValue getFilter() {
		TestFilter testFilter = new TestFilter("test", 1, true, 1.0);
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(testFilter);
		SimpleBeanPropertyFilter
			filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field4");
		FilterProvider filters = new SimpleFilterProvider().addFilter("TestFilter", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}

	@GetMapping("filter-list")
	public MappingJacksonValue getFilterList() {
		List<TestFilter> testFilterList = new ArrayList<>();
		testFilterList.add(new TestFilter("test", 1, true, 1.0));
		testFilterList.add(new TestFilter("test2", 2, false, 2.0));
		testFilterList.add(new TestFilter("test3", 3, true, 3.0));
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(testFilterList);
		SimpleBeanPropertyFilter
			filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field4", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("TestFilter", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}
}
