FROM ubuntu

RUN apt update \
        && apt install default-jre -y \
        && apt install default-jdk -y \
        && apt install openjdk-11-jdk -y \
        && apt-get -y install make

EXPOSE 5050
EXPOSE 4040

COPY . /usr/src/app

WORKDIR /usr/src/app

CMD make start
