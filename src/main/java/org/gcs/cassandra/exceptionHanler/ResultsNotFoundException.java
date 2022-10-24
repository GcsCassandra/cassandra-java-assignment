package org.gcs.cassandra.exceptionHanler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Found Empty Results")
public class ResultsNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}
