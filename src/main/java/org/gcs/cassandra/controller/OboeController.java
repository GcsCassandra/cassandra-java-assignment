package org.gcs.cassandra.controller;

import java.util.List;

import org.gcs.cassandra.entity.ScanLocation;
import org.gcs.cassandra.entity.ScanResults;
import org.gcs.cassandra.exceptionHanler.EntityNotFoundException;
import org.gcs.cassandra.exceptionHanler.ResultsNotFoundException;
import org.gcs.cassandra.pojo.ScanLocationPojo;
import org.gcs.cassandra.pojo.ScanResultsPojo;
import org.gcs.cassandra.service.ScanLocationService;
import org.gcs.cassandra.service.ScanResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "/oboe")
@Api(value = "OBOE Applicaiton", produces = "application/json")
public class OboeController {

	@Autowired
	ScanLocationService scanlocationService;

	@Autowired
	ScanResultsService scanResultsService;

	@ApiOperation(value = "Get All Scanned Locations", produces = "application/json")
	@GetMapping("/location/getAll")
	public ResponseEntity<List<ScanLocation>> getAllScanLocation() {
		List<ScanLocation> scanLocations = scanlocationService.getAllScanLocations();
		if (scanLocations.size() != 0 && !scanLocations.isEmpty()) {
			return new ResponseEntity<>(scanLocations,HttpStatus.OK);
		} else {
			throw new EntityNotFoundException();
		}
	}
	
	@ApiOperation(value = "Get Scanned Location based of locationId", produces = "application/json")
	@ApiImplicitParam(name = "locationId", value = "locationId", required = true, dataType = "String", paramType = "path")
	@GetMapping("/location/{locationId}")
	public ResponseEntity<ScanLocation> getScanLocationByLocationId(@PathVariable("locationId") String locationId) {
		ScanLocation scanLocation = scanlocationService.getScanLocationByLocationId(locationId);
		if (scanLocation!= null) {
			return new ResponseEntity<>(scanLocation,HttpStatus.OK);
		} else {
			throw new EntityNotFoundException();
		}
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiOperation(value = " Read new scan location", produces = "application/json")
	@PostMapping("/location/create")
	public <T> ResponseEntity<T> createLocation(@RequestBody ScanLocationPojo location) {
		scanlocationService.saveScanLocation(location);
		return new ResponseEntity(HttpStatus.CREATED);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiOperation(value = " Read Satellite Scan Result ", produces = "application/json")
	@PostMapping("/scan/create")
	public <T> ResponseEntity<T> createScan(@RequestBody ScanResultsPojo scanResults) {
		scanResultsService.saveScanResult(scanResults);
		return new ResponseEntity(HttpStatus.CREATED);
	}

	@ApiOperation(value = "Search Scan results based on ScanDate and LocationID ", produces = "application/json")
	 @ApiImplicitParams({
         @ApiImplicitParam(name = "scanDate", value = " scanDate", required = true, dataType = "String", paramType = "path"),
         @ApiImplicitParam(name = "locationId", value = "locationId", required = true, dataType = "String", paramType = "path")
          })
	@GetMapping("/scan/getScan/{scanDate}/{locationId}")
	public ResponseEntity<List<ScanResults>> findScanByDateWithLocation(@PathVariable("scanDate") String scanDate,
			@PathVariable("locationId") String locationId) {
		List<ScanResults> scanResults = scanResultsService.findScanByDateWithLocation(scanDate, locationId);

		if (scanResults.size() != 0) {
			return new ResponseEntity<>(scanResults,HttpStatus.OK);
		} else {
			throw new ResultsNotFoundException();
		}

	}
}
