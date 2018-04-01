.PHONY: test

test:
	@ echo "Execute bowling game unit tests"
	@ docker run -it --rm -v ${HOME}/.m2:/root/.m2  -v ${PWD}:/app -w /app maven:3-jdk-8-alpine mvn clean test
