FROM openjdk:11-jdk

RUN apt-get update && apt-get install -y ant

RUN mkdir -p ~/.jpf && touch ~/.jpf/site.properties && \
    echo "mcapl = ${HOME}/mcapl" >> ~/.jpf/site.properties

RUN ls -a

COPY . /mcapl
WORKDIR /mcapl
	
RUN ant compile
