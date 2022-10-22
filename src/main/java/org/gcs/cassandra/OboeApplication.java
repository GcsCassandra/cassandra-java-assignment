package org.gcs.cassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OboeApplication{

	/*
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder application) { return
	 * application.sources(OboeApplication.class); }
	 */
	public static void main(String[] args) {
		SpringApplication.run(OboeApplication.class, args);
	}
}
