package org.gcs.cassandra.dao;

import java.util.List;

import org.gcs.cassandra.entity.ScanLocation;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ScanLocationRepository extends CassandraRepository<ScanLocation, String> {
	/**
	 * Based on the requirement, we can see predefined methods saveAll() and findAll() methods
	 * which are available in JPA Repository or use native queries like below.   
	 * **/
	
	// To save location using native Query
	@Query(value = "insert into scan_location (location_Id,location_name) values(:locationId,:locationName)")
	Integer saveScanLocation(@Param("locationId") String locationId, @Param("locationName") String locaitonName);

	// To get all the locations using native Query
	@Query(value = "Select * from scan_location")
	List<ScanLocation> getAllScanLocation();
	
	@Query(value = "Select * from scan_location where location_id= :locationId")
	ScanLocation getScanLocationById(@Param("locationId") String locationId);
}
