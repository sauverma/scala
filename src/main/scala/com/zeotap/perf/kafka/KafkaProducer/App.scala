package com.zeotap.perf.kafka.KafkaProducer

import java.io.BufferedReader
import java.io.FileReader

import org.apache.commons.cli.CommandLineParser
import org.apache.commons.cli.GnuParser
import org.apache.commons.cli.Options

import com.google.gson.Gson

/**
 * @author ${user.name}
 */
object App {

  def main(args: Array[String]) {
    var options = new Options();
    options.addOption("c", true, "Config file path");

    var parser: CommandLineParser = new GnuParser();
    var cmd = parser.parse(options, args);
    
    if (cmd.hasOption("c")) {

      var filepath = cmd.getOptionValue("c");
      var gson = new Gson();
      var br : BufferedReader = new BufferedReader(new FileReader(filepath));
      var config : Config = gson.fromJson(br, classOf[Config]);
      
      var producer = new Producer(config);
      
      println(config);
    } else {
      println("Error : mention config json path");
      System.exit(-1);
    }
    
  }

}
