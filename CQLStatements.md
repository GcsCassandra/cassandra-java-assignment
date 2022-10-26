# Cassandra CQL Statements

Use this file to include your DDL.  Also include any DML that you may have created.


## DDL

## To create KeySpace

CREATE KEYSPACE oboe WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'} AND durable_writes = true;

## To create scan_location table

CREATE TABLE oboe.scan_location (
    location_id text PRIMARY KEY,
    location_name text
) WITH bloom_filter_fp_chance = 0.01
    AND caching = {'keys': 'ALL', 'rows_per_partition': 'NONE'}
    AND comment = ''
    AND compaction = {'class': 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy', 'max_threshold': '32', 'min_threshold': '4'}
    AND compression = {'chunk_length_in_kb': '64', 'class': 'org.apache.cassandra.io.compress.LZ4Compressor'}
    AND crc_check_chance = 1.0
    AND dclocal_read_repair_chance = 0.1
    AND default_time_to_live = 0
    AND gc_grace_seconds = 864000
    AND max_index_interval = 2048
    AND memtable_flush_period_in_ms = 0
    AND min_index_interval = 128
    AND read_repair_chance = 0.0
    AND speculative_retry = '99PERCENTILE';

## To create scan_results table

CREATE TABLE oboe.scan_results (
    scan_date text,
    location_id text,
    bird_species text,
    bird_traits list<text>,
    bird_uuid uuid,
    PRIMARY KEY (scan_date, location_id)
) WITH CLUSTERING ORDER BY (location_id DESC)
    AND bloom_filter_fp_chance = 0.01
    AND caching = {'keys': 'ALL', 'rows_per_partition': 'NONE'}
    AND comment = ''
    AND compaction = {'class': 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy', 'max_threshold': '32', 'min_threshold': '4'}
    AND compression = {'chunk_length_in_kb': '64', 'class': 'org.apache.cassandra.io.compress.LZ4Compressor'}
    AND crc_check_chance = 1.0
    AND dclocal_read_repair_chance = 0.1
    AND default_time_to_live = 0
    AND gc_grace_seconds = 864000
    AND max_index_interval = 2048
    AND memtable_flush_period_in_ms = 0
    AND min_index_interval = 128
    AND read_repair_chance = 0.0
    AND speculative_retry = '99PERCENTILE';

## DML (if any)

## sample data insertion on scan_location table  
insert into scan_location(location_id,location_name) values ('25N,71W','bermudaTriangle');

## sample data insertion on scan_results table  
 insert into scan_results(scan_date,location_id,bird_uuid,bird_species,bird_traits) values('2025-08-17', '25N,71W',now(),'common loon',['redeyes','swim and dive','webbed feet']) IF NOT EXISTS;
