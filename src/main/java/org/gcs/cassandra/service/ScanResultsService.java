package org.gcs.cassandra.service;

import java.util.List;
import java.util.Optional;

import org.gcs.cassandra.entities.ScanResults;

public interface ScanResultsService {

	public Object saveScanResults(ScanResults birdscan);

	public List<ScanResults> getScanResults();

	public boolean checkIfBirdSpeciesAlreadyExists(String birdSpecies);
	
	public Optional<ScanResults> getBirdscansByUniqueId(String uniqueId);
	

}
