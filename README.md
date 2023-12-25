# Connector to IbmMQ

#### First I recommend to setup IbmMQ inside local docker container

To set up container all we need is:

- docker run --rm --env LICENSE=accept --env MQ_QMGR_NAME=QM1 --publish 1414:1414 --publish 9443:9443 --detach  --name QM1 ibmcom/mq
- after container startup we've got to enter to IbmMQ console - https://localhost:9443/ibmmq/console/
- now we can login inside using default credentials (admin/passw0rd)
- default queue manager is called QM1 after entering given QM we need to send message
- input queue that we're using for testing purposes is DEV.QUEUE.1


#### General purpose of our application
Mainly we set up the connection to IbmMQ to send specify message and process it to perform action on them.
What we did in our processors is:
- business logic
- handling specify exceptions
- create onException routes to send messages to track corrupted messages


#### Docker Image
To run whole project we would need well configured environment that allows us to run code.
To omit those problem I've created the docker image that posses current version of jar,
to visualize how application works and give possibility to manipulate those.
