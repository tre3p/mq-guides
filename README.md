# spring-guides

## rmq-spring
First, you need to start RabbitMQ in docker-container:

```sh
docker run -it --rm --name rabbitmq -p 5600:5672 -p 15670:15672 rabbitmq:3.9-management
```

Then you can launch both of apps:

```sh
cd rmq-spring
make start
```
