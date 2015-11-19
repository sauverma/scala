package com.zeotap.perf.kafka.KafkaProducer

import java.util.Properties
import kafka.producer.ProducerConfig
import kafka.producer.KeyedMessage

class Producer (config : Config) {
  def properties = new Properties();
  
  properties.put("metadata.broker.list", config.brokers)
  properties.put("serializer.class", "kafka.serializer.StringEncoder")
  properties.put("request.required.acks", new Integer(config.ackReq))
  properties.put("compression.codec", config.compression)
  
  val producerConf = new ProducerConfig(properties)
  val producer = new kafka.producer.Producer[String, String](producerConf)
  
  def sendMessage(msg : String) = {
    var kMsg = new KeyedMessage[String, String](config.topic, msg)
    producer.send(kMsg);
  }
}