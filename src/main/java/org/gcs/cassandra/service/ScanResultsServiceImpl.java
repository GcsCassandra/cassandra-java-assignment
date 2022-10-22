package org.gcs.cassandra.service;

import java.util.List;
import java.util.Optional;

import org.gcs.cassandra.dao.ScanResultsRepository;
import org.gcs.cassandra.entities.ScanResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScanResultsServiceImpl implements ScanResultsService {

	@Autowired
	ScanResultsRepository scanResultsRepository;

	@Override
	public Object saveScanResults(ScanResults scanResults) {
		return scanResultsRepository.save(scanResults);
	}

	@Override
	public List<ScanResults> getScanResults() {
		return scanResultsRepository.findAll();
	}

	@Override
	public boolean checkIfBirdSpeciesAlreadyExists(String birdSpecies) {
		return scanResultsRepository.findByBirdSpecies(birdSpecies);
	}

	@Override
	public Optional<ScanResults> getBirdscansByUniqueId(String uniqueId) {
		List<ScanResults> temp =  getScanResults();
		return getScanResults().stream().filter(bird-> bird.getUniqueBirdId().toString().equals(uniqueId)).findFirst();	
	}



}
