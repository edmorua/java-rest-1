package com.apsus.restapi.restful_web_services.filtering;


import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("TestFilter")
public class TestFilter {

	private String field1;
	private int field2;
	private boolean field3;
	private double field4;

	public TestFilter(String field1, int field2, boolean field3, double field4) {
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public int getField2() {
		return field2;
	}

	public void setField2(int field2) {
		this.field2 = field2;
	}

	public boolean isField3() {
		return field3;
	}

	public void setField3(boolean field3) {
		this.field3 = field3;
	}

	public double getField4() {
		return field4;
	}

	public void setField4(double field4) {
		this.field4 = field4;
	}

	@Override
	public String toString() {
		return "TestFilter{" +
			"field1='" + field1 + '\'' +
			", field2=" + field2 +
			", field3=" + field3 +
			", field4=" + field4 +
			'}';
	}
}
