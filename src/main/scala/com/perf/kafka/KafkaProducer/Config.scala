package com.perf.kafka.KafkaProducer

case class Config (topic : String, zk : String, brokers : String, numPthreads : Int, numMsgs :  Long, compression : String, ackReq : Int) {
  
  override def toString = "[" + topic + " : " + zk + " : " + brokers + " : " + numPthreads + " : " + numMsgs + " : " + compression + " : " + ackReq + "]"
}