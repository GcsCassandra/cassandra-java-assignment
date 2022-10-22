package org.gcs.cassandra.dao;

import java.time.LocalDate;
import java.util.List;

import org.gcs.cassandra.entities.ScanResultsKey;
import org.gcs.cassandra.entities.ScanResultsOnLocations;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ScanResultsOnLocationsRepository extends CassandraRepository<ScanResultsOnLocations, ScanResultsKey>{
	List<ScanResultsOnLocations> findAllByKey_ScanDateAndKey_LocationName(LocalDate scanDate,String location);
}
