zookeeper-server-start.bat C:\WorkSpace\kafka_2.13-2.8.0\config\zookeeper.properties
kafka-server-start.bat ..\..\config\server.properties
kafka-server-start.bat ..\..\config\server1.properties
kafka-server-start.bat ..\..\config\server2.properties

kafka-topics.bat --create --topic test-topic -zookeeper localhost:2181 --replication-factor 1 --partitions 4
kafka-console-producer.bat --broker-list localhost:9092 --topic test-topic
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test-topic --from-beginning

Kafka Message Sending with key\................................................

kafka-console-producer.bat --broker-list localhost:9092 --topic test-topic --property "key.separator=-" --property "parse.key=true"

List the topics in a cluster
kafka-topics.bat --zookeeper localhost:2181 --list


Describe topic
The below command can be used to describe all the topics.
kafka-topics.bat --zookeeper localhost:2181 --describe
The below command can be used to describe a specific topic.
kafka-topics.bat --zookeeper localhost:2181 --describe --topic <topic-name>

How to view consumer groups
kafka-consumer-groups.bat --bootstrap-server localhost:9092 --list
With Consumer Group
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test-topic --group console-consumer-54498
now create console producer:
kafka-console-producer.bat --broker-list localhost:9092 --topic test-topic

Viewing the Commit Log
kafka-run-class.bat kafka.tools.DumpLogSegments --deep-iteration --files /tmp/kafka-logs/test-topic-0/00000000000000000000.log

kafka-run-class.bat kafka.tools.DumpLogSegments --deep-iteration --files C:/WorkSpace/kafka_2.13-2.8.0/logs/test-topic-0/00000000000000000000.log

 in distrubuter mode create topics
 kafka-topics.bat --create --topic test-topic-replicated -zookeeper localhost:2181 --replication-factor 3 --partitions 3
 producer 
 kafka-console-producer.bat --broker-list localhost:9092 --topic test-topic-replicated
 consumer
 kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test-topic-replicated --from-beginning
 
 Replication Replication
 who is the leader and who is replicated?
 descibet particuarl topic
 kafka-topics.bat --zookeeper localhost:2181 --describe --topic test-topic-replicated