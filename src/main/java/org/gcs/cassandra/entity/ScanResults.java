package org.gcs.cassandra.entity;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(value = "scan_results")
public class ScanResults {

	@PrimaryKey
	private ScanResultsKey scanResultsKey;

	@Column(value = "bird_uuid")
	private UUID birdUuid;

	@Column(value = "bird_species")
	private String birdSpecies;

	@Column(value = "bird_traits")
	private List<String> birdTraits;


	
}
