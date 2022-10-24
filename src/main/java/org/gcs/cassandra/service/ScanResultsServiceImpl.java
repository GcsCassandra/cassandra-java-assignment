package org.gcs.cassandra.service;

import java.util.List;

import org.gcs.cassandra.dao.ScanLocationRepository;
import org.gcs.cassandra.dao.ScanResultsRepository;
import org.gcs.cassandra.entity.ScanResults;
import org.gcs.cassandra.pojo.ScanResultsPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScanResultsServiceImpl implements ScanResultsService {

	@Autowired
	ScanLocationRepository scanLocationRepository;

	@Autowired
	ScanResultsRepository scanResultsRepository;

	public void saveScanResult(ScanResultsPojo scanResults) {
		scanResultsRepository.saveScanResult(scanResults.getScanResultsKey().getScanDate(), scanResults.getScanResultsKey().getLocationId(),
				scanResults.getBirdUuid(), scanResults.getBirdSpecies(), scanResults.getBirdTraits());

	}

	
	public List<ScanResults> findScanByDateWithLocation(String date, String location) {
		return scanResultsRepository.findScanByDateWithLocation(date, location);
		 
	}

}
