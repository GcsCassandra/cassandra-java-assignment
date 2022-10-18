package org.gcs.cassandra.entities;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Locations {

	@PrimaryKey
	private int id;
	private String geoLocation;
	private String locationName;

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

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	@Override
	public String toString() {
		return "Locations [id=" + id + ", geoLocation=" + geoLocation + ", locationName=" + locationName + "]";
	}

	public Locations() {
		super();
	}

}
