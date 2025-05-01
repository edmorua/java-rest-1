package com.apsus.restapi.restful_web_services.hello;

public class HelloWorldBean {


    public HelloWorldBean(String message) {
        this.message = message;
    }


    private String message;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean [message " + message + " ]";
    }
}
