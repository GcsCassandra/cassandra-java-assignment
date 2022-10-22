package org.gcs.cassandra.dao;

import org.gcs.cassandra.entities.ScanLocations;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScanLocationRepository extends CassandraRepository<ScanLocations, String> {
	
	boolean findByName(String name);
	
}
