# poems_app

Java Spring backend and Angular frontend to offer a configurable tool for storing texts with metadata and bibliographies. The project offers best support for presenting texts encoded in XML according to SAWS-TEI-standards.

Makes use of the [Frontend-Maven-Plugin](https://github.com/eirslett/frontend-maven-plugin) to package frontend and backend in a single jar-file.
Makes use of [Apache Kafka](https://kafka.apache.org/) to integrate time consuming tasks with a REST architecture.
Makes use of [Apache Solr and SolrJ](https://solr.apache.org/) to enable full-text searchs.
Stores data in a [MySQL](www.mysql.com) database.
