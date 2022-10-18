package org.gcs.cassandra.service;

import java.util.List;
import java.util.Optional;

import org.gcs.cassandra.entities.BirdScan;
import org.gcs.cassandra.exceptions.BirdscanExcpetions;

public interface BirdScansService {

	public Object saveBirdScans(BirdScan birdscan);

	public List<BirdScan> getBirdScans();

	public boolean checkIfIdAlreadyExists(int id);
	
	public Optional<BirdScan> getBirdscansByUniqueId(String uniqueId);
	
	public Optional<BirdScan> getBirdscanByid(int id);
	
	public void deleteBirdscanByid(int id);

}
