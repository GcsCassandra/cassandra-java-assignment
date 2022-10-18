package org.gcs.cassandra.dao;

import org.gcs.cassandra.entities.Locations;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CassandraRepository<Locations, Integer> {

}
