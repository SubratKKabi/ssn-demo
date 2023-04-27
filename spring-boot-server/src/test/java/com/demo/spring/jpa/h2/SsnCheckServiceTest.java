package com.demo.spring.jpa.h2;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.spring.service.SsnCheckService;

import static org.junit.jupiter.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Map;
@ExtendWith(MockitoExtension.class)
class SsnCheckServiceTest {

@Autowired	
private SsnCheckService ssnCheckService;

	   @Test 
	   void isValidSSNValidTest() {
		   ssnCheckService = new SsnCheckService();
		   Map<String,String> result =ssnCheckService.isValidSSN("856-45-6789");
		   assertTrue(result.containsKey("true"));
	    }
	   
	   @Test 
	   void isValidSSNNullTest() {
		   ssnCheckService = new SsnCheckService();
		   Map<String,String> result =ssnCheckService.isValidSSN(null);
		   assertFalse(result.containsKey("true"));
	    }
	   
	   @Test 
	   void isValidSSNInvalidFormat1Test() {
		   ssnCheckService = new SsnCheckService();
		   Map<String,String> result =ssnCheckService.isValidSSN("000-45-6789");
		   assertFalse(result.containsKey("true"));
	    }
	   
	   @Test 
	   void isValidSSNInvalidFormat2Test() {
		   ssnCheckService = new SsnCheckService();
		   Map<String,String> result =ssnCheckService.isValidSSN("000-45-678");
		   assertFalse(result.containsKey("true"));
	    }
	   
	   @Test 
	   void isValidSSNInvalidFormat3Test() {
		   ssnCheckService = new SsnCheckService();
		   Map<String,String> result =ssnCheckService.isValidSSN("000-45-0000");
		   assertFalse(result.containsKey("true"));
	    }
	   
	 

}
