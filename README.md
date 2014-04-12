hadoop-log-getter
=================

A simple tool to show all logs of a Hadoop job

* Takes the job id
* Asks the YARN History Server REST-API for the log URLs of all job attempts
* Scrapes the log pages
* Strips the HTML surrounding the log output
* Returns everything on one page

Prerequisites
-------------
* Hadoop >= 2.0, tested with 2.0.6-alpha
* History Server installed and configured
* Maven for building

Usage
-----
~~~~ 
mvn package
java -jar target/log-getter-1.0-SNAPSHOT.jar
~~~~
* Find out job id (e.g. job_1234567890123_1234)
* Call http://localhost:8080/<job id> (e.g. http://localhost:8080/job_1234567890123_1234)


Limitations
-----------
* Works for already finished jobs only
* Returns all logs in a single request, could be very slow

