package org.gcs.cassandra.service;

import java.util.List;

import org.gcs.cassandra.entities.ScanLocations;

public interface ScanLocationsService {

	public Object saveLocations(ScanLocations location);

	public List<ScanLocations> getLocations();

	public boolean checkIfNameAlreadyExists(String name);
	
	public void saveAll(List<ScanLocations> list);
}
