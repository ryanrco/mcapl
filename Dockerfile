FROM jlesage/baseimage-gui:debian-11-v4

RUN apt-get update && \
    apt-get install -y openjdk-11-jdk ant xterm && \
    apt-get clean

RUN mkdir -p ~/.jpf && touch ~/.jpf/site.properties && \
    echo "mcapl = ${HOME}/mcapl" >> ~/.jpf/site.properties

COPY . /mcapl

WORKDIR /mcapl
RUN ant clean jar

WORKDIR /

COPY startapp.sh /startapp.sh
RUN set-cont-env APP_NAME "trainsim"