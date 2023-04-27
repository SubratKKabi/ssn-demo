package com.demo.spring.jpa.h2.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.jpa.h2.model.Ssn;
import com.demo.spring.jpa.h2.repository.SsnRepository;
import com.demo.spring.service.SsnCheckService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SsnController {


	@Autowired
	SsnRepository ssnRepository;
	
	@Autowired
	SsnCheckService ssnCheckService;

	
	@GetMapping("/ssn")
	public ResponseEntity<List<Ssn>> getAllSsns(@RequestParam(required = false) String val) {
		try {
			List<Ssn> ssn = new ArrayList<Ssn>();

			if (val == null)
				ssnRepository.findAll().forEach(ssn::add);			

			if (ssn.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(ssn, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/ssn")
	public ResponseEntity<Object> createSsn(@RequestBody Ssn ssn) {
		try {
			List<String> result  = new ArrayList<String>();
			HashMap<String,String> ssnValidCheck = (HashMap<String, String>) ssnCheckService.isValidSSN(ssn.getSsn());
			if(ssnValidCheck.containsKey("true")) {
				ssn.setId(1);
				ssnRepository.save(new Ssn(ssn.getSsn()));	
				result.add(ssnValidCheck.get("true"));
			return new ResponseEntity<>(result, HttpStatus.OK);
			}else {
				result.add(ssnValidCheck.get("false"));
				return new ResponseEntity<>(result, HttpStatus.OK);
			}
		} catch (Exception e) {
						return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	
	@DeleteMapping("/ssn")
	public ResponseEntity<HttpStatus> deleteAllSsns() {
		try {
			ssnRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	

}
