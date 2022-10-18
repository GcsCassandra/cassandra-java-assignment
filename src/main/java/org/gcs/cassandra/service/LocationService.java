package org.gcs.cassandra.service;

import java.util.List;

import org.gcs.cassandra.entities.Locations;

public interface LocationService {

	public Object saveLocations(Locations location);

	public List<Locations> getLocations();

	public boolean checkIfIdAlreadyExists(int id);
	
	public void deleteLocationByid(int id);
}
