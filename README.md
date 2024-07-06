We dive into practical demonstrations. Discover how to create Kafka producers efficiently and send messages both synchronously and asynchronously. Learn the nuances of sending messages with and without keys, and explore strategies for efficient message routing and consumption.

We then explore advanced topics including custom message production and consumption, handling consumer partition rebalancing with multiple consumers, and optimizing offset commitments for reliability.
we emphasize best practices for error handling and discuss considerations for deploying Kafka applications outside of cloud environments or Kubernetes.

Whether you're new to Kafka or looking to deepen your understanding, this video provides actionable insights and practical examples that will accelerate your journey towards mastering Kafka with Spring Boot.

# SPRING BOOT OFFICIAL PAGE:
https://docs.spring.io/spring-kafka/reference/kafka/receiving-messages/message-listener-container.html

# START THE KAFKA ENVIRONMENT:
NOTE: Your local environment must have Java 8+ installed.

Apache Kafka can be started using ZooKeeper or KRaft. To get started with either configuration follow one of the sections below but not both.

# Kafka with ZooKeeper:
Run the following commands in order to start all services in the correct order:

Start the ZooKeeper service
$ bin/zookeeper-server-start.sh config/zookeeper.properties
Open another terminal session and run:

Start the Kafka broker service
$ bin/kafka-server-start.sh config/server.properties
Once all services have successfully launched, you will have a basic Kafka environment running and ready to use.

# Kafka with KRaft:
Kafka can be run using KRaft mode using local scripts and downloaded files or the docker image. Follow one of the sections below but not both to start the kafka server.

Generate a Cluster UUID
$ KAFKA_CLUSTER_ID="$(bin/kafka-storage.sh random-uuid)"

Format Log Directories
$ bin/kafka-storage.sh format -t $KAFKA_CLUSTER_ID -c config/kraft/server.properties

Start the Kafka Server
$ bin/kafka-server-start.sh config/kraft/server.properties
