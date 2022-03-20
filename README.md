# Desription:
Repo for my education purposes. Making some Java examples with new for me techonologies.
You can see all of routes in controllers of applications. Sorry, i'm too lazy :P

## rmq-spring
Desription: app which sends messages to consumer application about user actions with RabbitMQ.

First, you need to start RabbitMQ in docker-container:

```sh
docker run -it --rm --name rabbitmq -p 5600:5672 -p 15670:15672 rabbitmq:3.9-management
```

Then you can launch both of apps:

```sh
cd rmq-spring
make start
```

## kafka-messaging
Description: app which receives JSON from user and sends it to consumer application, which saves it to database. Apache Kafka used to transfer JSON.

Before starting application, you need to make sure that you have PostgreSQL launched(for consumer application) and environment variable SPRING_DATASOURCE_URL is filled with JDBC to specified database.

To start application, you can manually start kafka server on your machine and then just execute following commands:

```sh
cd kafka-messaging
make start
```

Alternatively, you can use my docker-compose, which will launch all application needed.

```sh
cd kafka-messaging
docker-compose up
```
