package org.gcs.cassandra.exceptions;

import java.util.Date;

public class ErrorDetails {
	
	private Date timestamp;
	private String details;
	private String httpstatus;
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getHttpstatus() {
		return httpstatus;
	}
	public void setHttpstatus(String httpstatus) {
		this.httpstatus = httpstatus;
	}
	@Override
	public String toString() {
		return "ErrorDetails [timestamp=" + timestamp + ", details=" + details + ", httpstatus=" + httpstatus + "]";
	}
	public ErrorDetails(Date timestamp, String details, String httpstatus) {
		super();
		this.timestamp = timestamp;
		this.details = details;
		this.httpstatus = httpstatus;
	}
}
