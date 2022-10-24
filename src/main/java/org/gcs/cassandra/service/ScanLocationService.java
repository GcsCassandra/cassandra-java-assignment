package org.gcs.cassandra.service;

import java.util.List;

import org.gcs.cassandra.entity.ScanLocation;
import org.gcs.cassandra.pojo.ScanLocationPojo;

public interface ScanLocationService {

	List<ScanLocation> getAllScanLocations();
	
	ScanLocation getScanLocationByLocationId(String locationID);

	Integer saveScanLocation(ScanLocationPojo location);

}
