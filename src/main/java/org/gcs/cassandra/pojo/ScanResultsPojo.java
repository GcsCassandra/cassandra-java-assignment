package org.gcs.cassandra.pojo;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ScanResultsPojo {

	private ScanResultsKeyPojo scanResultsKey;

	private UUID birdUuid;

	private String birdSpecies;

	private List<String> birdTraits;

}
