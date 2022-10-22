package org.gcs.cassandra.entities;

import java.time.LocalDate;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class ScanResultsKey {
		
	public ScanResultsKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PrimaryKeyColumn(name = "scanDate", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private LocalDate scanDate;
	
	@PrimaryKeyColumn(name = "locationName", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
	private String locationName;
	
	@PrimaryKeyColumn(name = "birdSpecies", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
	private String birdSpecies;

	public LocalDate getScanDate() {
		return scanDate;
	}

	public void setScanDate(LocalDate scanDate) {
		this.scanDate = scanDate;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getBirdSpecies() {
		return birdSpecies;
	}

	public void setBirdSpecies(String birdSpecies) {
		this.birdSpecies = birdSpecies;
	}

	public ScanResultsKey(LocalDate scanDate, String locationName, String birdSpecies) {
		super();
		this.scanDate = scanDate;
		this.locationName = locationName;
		this.birdSpecies = birdSpecies;
	}
	
	
	
}
