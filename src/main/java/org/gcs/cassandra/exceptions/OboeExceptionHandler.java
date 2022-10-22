package org.gcs.cassandra.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OboeExceptionHandler {

	@ExceptionHandler(value = ScanResultsNotFoundException.class)
	public ResponseEntity<?> handleExcpetion(ScanResultsNotFoundException ex) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(System.currentTimeMillis()), ex.getMessage(),
				HttpStatus.NOT_FOUND.toString());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = EmptyListException.class)
	public ResponseEntity<?> handleExcpetion1(EmptyListException ex) {

		ErrorDetails errorDetails = new ErrorDetails(new Date(System.currentTimeMillis()), ex.getMessage(),
				HttpStatus.NOT_FOUND.toString());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

}
