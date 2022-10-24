package org.gcs.cassandra;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.gcs.cassandra.dao.ScanLocationRepository;
import org.gcs.cassandra.dao.ScanResultsRepository;
import org.gcs.cassandra.entity.ScanLocation;
import org.gcs.cassandra.entity.ScanResults;
import org.gcs.cassandra.entity.ScanResultsKey;
import org.gcs.cassandra.service.ScanLocationService;
import org.gcs.cassandra.service.ScanResultsService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ControllerTest {

	@MockBean
	ScanLocationRepository scanLocationRepository;
	
	@MockBean
	ScanResultsRepository scanResultsRepository;
	
	@Autowired
	ScanResultsService scanResultsService;
	
	@Autowired
	ScanLocationService scanLocationService;

	@Test
	public void getAllLocations() {
		when(scanLocationRepository.getAllScanLocation()).thenReturn(
				 Stream.of(new ScanLocation("10N,10S","location1"),new ScanLocation("1N,1S","location2")).collect(Collectors.toList()));

		assertEquals(2, scanLocationService.getAllScanLocations().size());
	}

	@Test
	public void findScanByDateWithLocation() {
		ScanResultsKey key = new ScanResultsKey();
		key.setLocationId("10N,10S");
		key.setScanDate("2022-10-24");
		
		List<String> birdProp = new ArrayList<>();
		birdProp.add("colourfull");
		birdProp.add("swim");
		
		when(scanResultsRepository.findScanByDateWithLocation(Mockito.anyString(),Mockito.anyString())).thenReturn(
				 Stream.of(new ScanResults(key,UUID.randomUUID(),"Sparrow",birdProp)).collect(Collectors.toList()));

		assertEquals(1, scanResultsService.findScanByDateWithLocation("10N,10S","2022-10-24").size());
	}
	
}
