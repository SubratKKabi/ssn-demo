package com.demo.spring.service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;

import org.springframework.stereotype.Service;

@Service
public class SsnCheckService {

	    // Function to validate
	    // SSN (Social Security Number).
	    public  Map<String,String> isValidSSN(String str)
	    {
	    	HashMap<String,String> result = new HashMap<>();
	        // Regex to check SSN
	        // (Social Security Number).
	        String regex = "^(?!666|000|9\\d{2})\\d{3}"
	                       + "\\.(?!00)\\d{2}\\."
	                       +"(?!0{4})\\d{4}$";
	 
	        // Compile the ReGex
	        Pattern p = Pattern.compile(regex);
	 
	        // If the string is empty
	        // return false
	        if (str == null)
	        {
	            
	        	result.put("false", "Please enter a valid SSN");
	        	return result;
	        	//return false;
	        }
	 
	        // Pattern class contains matcher()
	        //  method to find matching between
	        //  given string and regular expression.
	        Matcher m = p.matcher(str);
	 
	        // Return if the string
	        // matched the ReGex
	        if(m.matches()) {
	        result.put("true", "The SSN is valid");
	        }else {
	        result.put("false", "The SSN has invalid format. Please enter a valid SSN");
	        }
	        return result;
	    }
	 
	
}
