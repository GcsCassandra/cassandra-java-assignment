package org.gcs.cassandra.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ScanResultsKeyPojo {
	private String scanDate;

	private String locationId;

}