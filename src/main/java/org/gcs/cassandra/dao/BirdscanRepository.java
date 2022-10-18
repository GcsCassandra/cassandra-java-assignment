package org.gcs.cassandra.dao;

import org.gcs.cassandra.entities.BirdScan;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirdscanRepository extends CassandraRepository<BirdScan, Integer> {

}
