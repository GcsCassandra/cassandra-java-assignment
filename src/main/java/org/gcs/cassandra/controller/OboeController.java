package org.gcs.cassandra.controller;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.gcs.cassandra.dao.ScanResultsOnLocationsRepository;
import org.gcs.cassandra.entities.ScanLocations;
import org.gcs.cassandra.entities.ScanResults;
import org.gcs.cassandra.entities.ScanResultsKey;
import org.gcs.cassandra.entities.ScanResultsOnLocations;
import org.gcs.cassandra.exceptions.EmptyListException;
import org.gcs.cassandra.exceptions.ScanResultsNotFoundException;
import org.gcs.cassandra.service.ScanLocationsService;
import org.gcs.cassandra.service.ScanResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OboeController {

	@Autowired
	ScanResultsService scanResultsService;
	
	@Autowired
	ScanLocationsService locationService;
	
	@Autowired
	ScanResultsOnLocationsRepository scanResultsOnLocationsRepository;

	@PostConstruct
	public void saveLocation() {
		ScanLocations locations = new ScanLocations("Bermuda Triangle", "257_N");
		ScanLocations location1 = new ScanLocations("America", "367_M");
		locationService.saveLocations(locations);
		locationService.saveLocations(location1);
	}

	@PostConstruct
	public void saveScanResultsOnLocation() {
		LocalDate date = LocalDate.of(2015, 8, 11);
		ScanResultsKey key = new ScanResultsKey(date, "Bermuda Triangle", "Common loon");
		ScanResultsOnLocations resultsOnLocations = new ScanResultsOnLocations();
		resultsOnLocations.setKey(key);
		Set<String> set = new HashSet<>();
		set.add("Red eyes");
		set.add("Balck wings");
		resultsOnLocations.setBirdtraits(set);
		UUID uuid = UUID.randomUUID();
		resultsOnLocations.setUniqueBirdId(uuid);
		scanResultsOnLocationsRepository.save(resultsOnLocations);

	}

	@PostMapping("/saveScanResults")
	public ResponseEntity<String> saveScanResults(@RequestBody ScanResults birdscan) {
		if (scanResultsService.checkIfBirdSpeciesAlreadyExists(birdscan.getBirdSpecies())) {
			return new ResponseEntity<>("Already Exists", HttpStatus.CONFLICT);
		}
		scanResultsService.saveScanResults(birdscan);
		return new ResponseEntity<>("Created", HttpStatus.CREATED);
	}

	@PostMapping("/saveScanLocations")
	public ResponseEntity<String> saveLocations(@RequestBody ScanLocations location) {
		if (locationService.checkIfNameAlreadyExists(location.getName())) {
			return new ResponseEntity<>("Already Exists", HttpStatus.CONFLICT);
		}
		locationService.saveLocations(location);
		return new ResponseEntity<>("Created", HttpStatus.CREATED);
	}

	@GetMapping("/getScanLocations")
	public ResponseEntity<?> getLocations() {
		List<ScanLocations> list = locationService.getLocations();
		if (list.isEmpty()) {
			throw new EmptyListException("scanlocatoins are empty");
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/getScanResultsbyLocationandDate")
	public ResponseEntity<?> getScanResultsByLocationAndDate(@RequestBody ScanResultsKey scanResultsKey) {
		List<ScanResultsOnLocations> scanResults = scanResultsOnLocationsRepository
				.findAllByKey_ScanDateAndKey_LocationName(scanResultsKey.getScanDate(),
						scanResultsKey.getLocationName());
		if (scanResults == null || scanResults.isEmpty()) {
			throw new ScanResultsNotFoundException("Result Not available for given Location and Date");
		}
		return new ResponseEntity<>(scanResults, HttpStatus.OK);
	}

}
