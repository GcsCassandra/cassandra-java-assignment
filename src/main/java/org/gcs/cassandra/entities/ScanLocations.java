package org.gcs.cassandra.entities;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "locations")
public class ScanLocations {

	@PrimaryKeyColumn(name= "name",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
	private String name;
	
	@CassandraType(type = Name.TEXT)
	private String location;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public ScanLocations() {
		super();
	}
	public ScanLocations(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}
	
}
