package org.gcs.cassandra.controller;

import java.util.List;
import java.util.Optional;

import org.gcs.cassandra.entities.BirdScan;
import org.gcs.cassandra.entities.Locations;
import org.gcs.cassandra.exceptions.BirdscanExcpetions;
import org.gcs.cassandra.exceptions.EmptyListException;
import org.gcs.cassandra.service.BirdScansService;
import org.gcs.cassandra.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OboeController {

	@Autowired
	BirdScansService birdScansService;
	@Autowired
	LocationService locationService;

	@PostMapping("/saveBirdScan")
	public ResponseEntity<String> saveBirdScans(@RequestBody BirdScan birdscan) {
		if (birdScansService.checkIfIdAlreadyExists(birdscan.getId())) {
			return new ResponseEntity<>("Already Exists", HttpStatus.CONFLICT);
		}
		birdScansService.saveBirdScans(birdscan);
		return new ResponseEntity<>("Created", HttpStatus.CREATED);
	}
	
	@PutMapping("/updateBirdScan")
	public ResponseEntity<String> updateBirdScans(@RequestBody BirdScan birdscan) {
		birdScansService.saveBirdScans(birdscan);
		return new ResponseEntity<>("updated", HttpStatus.OK);
	}

	@PostMapping("/saveLocations")
	public ResponseEntity<String> saveLocations(@RequestBody Locations location) {
		if (locationService.checkIfIdAlreadyExists(location.getId())) {
			return new ResponseEntity<>("Already Exists", HttpStatus.CONFLICT);
		}
		locationService.saveLocations(location);
		return new ResponseEntity<>("Created", HttpStatus.CREATED);
	}

	@GetMapping("/getBirdScans")
	public ResponseEntity<?> getBirdScans() {
		List<BirdScan> list = birdScansService.getBirdScans();
		if(list.isEmpty()) {
			throw new EmptyListException("List is empty");
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/getLocations")
	public ResponseEntity<?> getLocations() {
		List<Locations> list = locationService.getLocations();
		if(list.isEmpty()) {
			throw new EmptyListException("List is empty");
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PutMapping("/updateLocations")
	public ResponseEntity<String> updateLocations(@RequestBody Locations location) {
		locationService.saveLocations(location);
		return new ResponseEntity<>("Updated", HttpStatus.OK);
	}
	
	@GetMapping("/getBirdscansByUniqueId")
	public ResponseEntity<?> getBirdscansByUniqueId(@RequestParam(value="uniqueid") String uniqueid) throws BirdscanExcpetions{
		Optional<BirdScan> birdscan= birdScansService.getBirdscansByUniqueId(uniqueid);
		if(birdscan.isEmpty()) {
			throw new BirdscanExcpetions("Details not avaiable for given id");
		}
		return new ResponseEntity<>(birdScansService.getBirdscansByUniqueId(uniqueid), HttpStatus.OK);
	}
	
	@GetMapping("/getBirdscans/{id}")
	public ResponseEntity<?> getBirdscansById(@PathVariable int id) throws BirdscanExcpetions  {
		Optional<BirdScan> birdscan= birdScansService.getBirdscanByid(id);
		if(birdscan.isEmpty()) {
			throw new BirdscanExcpetions("Details not avaiable for given id");
		}
		return new ResponseEntity<>(birdscan, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteBirdscans/{id}")
	public ResponseEntity<?> deleteBirdscansById(@PathVariable int id) throws BirdscanExcpetions  {
		birdScansService.deleteBirdscanByid(id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteLocation/{id}")
	public ResponseEntity<?> deleteLocationById(@PathVariable int id) throws BirdscanExcpetions  {
		locationService.deleteLocationByid(id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}
}
