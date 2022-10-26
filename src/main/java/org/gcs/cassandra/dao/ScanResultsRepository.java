package org.gcs.cassandra.dao;

import java.util.List;
import java.util.UUID;

import org.gcs.cassandra.entity.ScanResults;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ScanResultsRepository extends CassandraRepository<ScanResults, Integer> {

	/**
	 * Based on the requirement, we can see predefined methods saveAll() and findAll() methods
	 * which are available in JPA Repository or use native queries like below.   
	 * **/
	
	// To get the scanResults based on the scan date and location Id the user given
	@Query(value = "select * from scan_results where scan_date= :scanDate and location_id=:locationId")
	List<ScanResults> findScanByDateWithLocation(@Param("scanDate") String scandate,@Param("locationId") String locationId);

	// To save the ScanResults, based on the user INPUT

	@Query(value = "insert into scan_results (scan_date,location_id, bird_uuid, bird_species,bird_traits) values(:scanDate,:locationId,:birduuid,:birdSpecies,:birdTraits);")
	void saveScanResult(@Param("scanDate") String scanDate, @Param("locationId") String locationId,
			@Param("birduuid") UUID birduuid, @Param("birdSpecies") String birdSpecies,
			@Param("birdTraits") List<String> birdTraits);
}
