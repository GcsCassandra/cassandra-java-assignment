package org.gcs.cassandra.entity;

import java.io.Serializable;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuppressWarnings("serial")
@PrimaryKeyClass
public class ScanResultsKey implements Serializable {
	@PrimaryKeyColumn(name = "scan_date", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private String scanDate;

	@PrimaryKeyColumn(name = "location_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
	private String locationId;

	
}