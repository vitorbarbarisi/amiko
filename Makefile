DEBUG_5005=-Drun.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5006"

run-postgres-docker:
	docker-compose up -d

run-dev-local: run-postgres-docker
	mvn spring-boot:run $(INVISIBLE) -Drun.profiles=dev,local $(DEBUG_5005)

run-dev:
	mvn spring-boot:run -Drun.profiles=dev