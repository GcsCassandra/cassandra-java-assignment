package org.gcs.cassandra.service;

import java.util.List;

import org.gcs.cassandra.dao.LocationRepository;
import org.gcs.cassandra.entities.Locations;
import org.gcs.cassandra.exceptions.BirdscanExcpetions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	LocationRepository locationRepository;

	@Override
	public Object saveLocations(Locations location) {
		// TODO Auto-generated method stub
		locationRepository.save(location);
		return null;
	}

	@Override
	public List<Locations> getLocations() {
		return locationRepository.findAll();

	}

	@Override
	public boolean checkIfIdAlreadyExists(int id) {
		return locationRepository.findById(id).isPresent();
	}

	@Override
	public void deleteLocationByid(int id) throws BirdscanExcpetions{		
		locationRepository.deleteById(id);
	}
}
