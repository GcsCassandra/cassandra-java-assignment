package org.gcs.cassandra.exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class oboeExceptionHandler {
	
	@ExceptionHandler(value = BirdscanExcpetions.class)
	public ResponseEntity<?> handleExcpetion(BirdscanExcpetions ex) {
		Map<String, String> response = new HashMap<>();
		
		response.put("birdScan", "birdScanService");
		response.put("timestamp", new Date().toString());
		response.put("error", ex.getMessage());
		response.put("status", HttpStatus.NOT_FOUND.name());
		return  new ResponseEntity<>(response,  HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = EmptyListException.class)
	public ResponseEntity<?> handleExcpetion(EmptyListException ex) {
		Map<String, String> response = new HashMap<>();
		
		response.put("birdScan", "birdScanService");
		response.put("timestamp", new Date().toString());
		response.put("error", ex.getMessage());
		response.put("status", HttpStatus.NOT_FOUND.name());
		return  new ResponseEntity<>(response,  HttpStatus.NOT_FOUND);
	}
	
	
}
