package org.gcs.cassandra.entities;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;

@Table
public class BirdScan {

	@PrimaryKey
	private int id;
	private String geoLocation;
	private LocalDate scanDate;
	private UUID uniqueBirdId;
	private String birdSpecies;
	private Set<String> birdtraits;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(String geoLocation) {
		this.geoLocation = geoLocation;
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

	public String getBirdSpecies() {
		return birdSpecies;
	}

	public void setBirdSpecies(String birdSpecies) {
		this.birdSpecies = birdSpecies;
	}

	public Set<String> getBirdtraits() {
		return birdtraits;
	}

	public void setBirdtraits(Set<String> birdtraits) {
		this.birdtraits = birdtraits;
	}

	@Override
	public String toString() {
		return "BirdScan [id=" + id + ", geoLocation=" + geoLocation + ", scanDate=" + scanDate + ", uniqueBirdId="
				+ uniqueBirdId + ", birdSpecies=" + birdSpecies + ", birdtraits=" + birdtraits + "]";
	}

	public BirdScan() {
		super();
	}

}
