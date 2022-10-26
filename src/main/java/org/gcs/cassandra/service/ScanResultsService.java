package org.gcs.cassandra.service;

import java.util.List;

import org.gcs.cassandra.entity.ScanResults;
import org.gcs.cassandra.pojo.ScanResultsPojo;

public interface ScanResultsService {

	void saveScanResult(ScanResultsPojo scanResults);
	List<ScanResults> findScanByDateWithLocation(String date,String location);

}
