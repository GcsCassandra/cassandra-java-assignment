package org.gcs.cassandra.entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(value = "scan_location")
public class ScanLocation {

	@PrimaryKeyColumn(value = "location_id",ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private String locationId;
	
	@Column(value = "location_name")
	private String locationName;
	
	
}
