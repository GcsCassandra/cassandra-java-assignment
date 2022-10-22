package org.gcs.cassandra.dao;

import org.gcs.cassandra.entities.ScanResults;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScanResultsRepository extends CassandraRepository<ScanResults, String> {
	
	boolean findByBirdSpecies(String birdSpecies);
}
