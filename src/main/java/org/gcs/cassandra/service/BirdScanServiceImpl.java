package org.gcs.cassandra.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.gcs.cassandra.dao.BirdscanRepository;
import org.gcs.cassandra.entities.BirdScan;
import org.gcs.cassandra.exceptions.BirdscanExcpetions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BirdScanServiceImpl implements BirdScansService {

	@Autowired
	BirdscanRepository birdscanRepository;

	@Override
	public Object saveBirdScans(BirdScan birdscan) {
		return birdscanRepository.save(birdscan);
	}

	@Override
	public List<BirdScan> getBirdScans() {
		return birdscanRepository.findAll();
	}

	@Override
	public boolean checkIfIdAlreadyExists(int id) {
		return birdscanRepository.findById(id).isPresent();
	}

	@Override
	public Optional<BirdScan> getBirdscansByUniqueId(String uniqueId) {
		List<BirdScan> temp =  getBirdScans();
		return getBirdScans().stream().filter(bird-> bird.getUniqueBirdId().toString().equals(uniqueId)).findFirst();	
	}

	@Override
	public Optional<BirdScan> getBirdscanByid(int id) throws BirdscanExcpetions{		
		return birdscanRepository.findById(id);
	}
	@Override
	public void deleteBirdscanByid(int id) throws BirdscanExcpetions{		
		 birdscanRepository.deleteById(id);
	}
	

}
