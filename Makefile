dev:
	mvn compile vertx:run
build:
	mvn clean package
	cd target
run:
	java -jar target/hello-microservice-http-1.0-SNAPSHOT.jar
brun:
	make build run