package com.camunda.workflow.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	
	
	   @GetMapping("/api/hello")
	    public String currencyDepositList(){
	        return "Hello wolrd";
	    }
	   @GetMapping("/hey")
	    public String hey(){
	        return "hey wolrd";
	    }
}
