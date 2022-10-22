package org.gcs.cassandra.entities;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

@Table( value = "scanresultsonlocations")
public class ScanResultsOnLocations {
	
	@PrimaryKey
	private ScanResultsKey key;
	
	@CassandraType(type = Name.UUID)
	private UUID uniqueBirdId;

	@CassandraType(type = Name.SET, typeArguments = Name.TEXT)
	private Set<String> birdtraits;

	public ScanResultsKey getKey() {
		return key;
	}

	public void setKey(ScanResultsKey key) {
		this.key = key;
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

	public ScanResultsOnLocations(ScanResultsKey key, UUID uniqueBirdId, Set<String> birdtraits) {
		super();
		this.key = key;
		this.uniqueBirdId = uniqueBirdId;
		this.birdtraits = birdtraits;
	}

	public ScanResultsOnLocations() {
		super();
	}
	
	
	
	
}
