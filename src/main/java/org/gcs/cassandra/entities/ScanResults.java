package org.gcs.cassandra.entities;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;

import java.time.LocalDate;

@Table(value = "scan_results")
public class ScanResults {

	@PrimaryKeyColumn(name = "birdSpecies", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private String birdSpecies;

	@CassandraType(type = Name.TEXT)
	private String location;

	@CassandraType(type = Name.DATE)
	private LocalDate scanDate;

	@CassandraType(type = Name.UUID)
	private UUID uniqueBirdId;

	@CassandraType(type = Name.SET, typeArguments = Name.TEXT)
	private Set<String> birdtraits;

	public String getBirdSpecies() {
		return birdSpecies;
	}

	public void setBirdSpecies(String birdSpecies) {
		this.birdSpecies = birdSpecies;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getScanDate() {
		return scanDate;
	}

	public void setScanDate(LocalDate scanDate) {
		this.scanDate = scanDate;
	}

	public UUID getUniqueBirdId() {
		return uniqueBirdId;
	}

	public void setUniqueBirdId(UUID uniqueBirdId) {
		this.uniqueBirdId = uniqueBirdId;
	}

	public Set<String> getBirdtraits() {
		return birdtraits;
	}

	public void setBirdtraits(Set<String> birdtraits) {
		this.birdtraits = birdtraits;
	}

	public ScanResults(String birdSpecies, String location, LocalDate scanDate, UUID uniqueBirdId,
			Set<String> birdtraits) {
		super();
		this.birdSpecies = birdSpecies;
		this.location = location;
		this.scanDate = scanDate;
		this.uniqueBirdId = uniqueBirdId;
		this.birdtraits = birdtraits;
	}

	public ScanResults() {
		super();
	}

}
