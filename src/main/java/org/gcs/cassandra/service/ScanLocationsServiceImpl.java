package org.gcs.cassandra.service;

import java.util.List;

import org.gcs.cassandra.dao.ScanLocationRepository;
import org.gcs.cassandra.entities.ScanLocations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScanLocationsServiceImpl implements ScanLocationsService {

	@Autowired
	ScanLocationRepository locationRepository;

	@Override
	public Object saveLocations(ScanLocations location) {
		// TODO Auto-generated method stub
		locationRepository.save(location);
		return null;
	}

	@Override
	public List<ScanLocations> getLocations() {
		return locationRepository.findAll();
	}

	@Override
	public boolean checkIfNameAlreadyExists(String name) {
		return locationRepository.findByName(name);
	}

	@Override
	public void saveAll(List<ScanLocations> list) {
		locationRepository.saveAll(list);
		
	}

}
