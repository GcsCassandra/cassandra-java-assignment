package org.gcs.cassandra.service;

import java.util.ArrayList;
import java.util.List;

import org.gcs.cassandra.dao.ScanLocationRepository;
import org.gcs.cassandra.entity.ScanLocation;
import org.gcs.cassandra.pojo.ScanLocationPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScanLocationServiceImpl implements ScanLocationService {

	@Autowired
	ScanLocationRepository scanLocationRepository;

	public List<ScanLocation> getAllScanLocations() {
		List<ScanLocation> scanLocations = new ArrayList<>();
		scanLocationRepository.getAllScanLocation().forEach(scanLocations::add);
		return scanLocations;
	}

	public Integer saveScanLocation(ScanLocationPojo location) {
		return scanLocationRepository.saveScanLocation(location.getLocationId(), location.getLocationName());

	}

	public ScanLocation getScanLocationByLocationId(String locationID) {
		return scanLocationRepository.getScanLocationById(locationID);
	}

}
