package org.skoosha;

import com.esotericsoftware.minlog.Log;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.skoosha.sinkClasses.KafkaSinkPipeline;
import org.skoosha.sourceClasses.KafkaConnectorPipeline;
import org.skoosha.streamEnv.ExecutionEnvironment;

public class Main {
    public static void main(String[] args)  {


        ExecutionEnvironment<String> env = new ExecutionEnvironment<>();

        try {

            DataStream<String> stream = env
                                    .createKafkaDataStream(new KafkaConnectorPipeline<String>()
                                    .buildKafkaSource(new SimpleStringSchema()));

            stream.print();

            stream.sinkTo(new KafkaSinkPipeline<String>().buildKafkaSink());

            env.getEnv().execute("Starter job");
        }catch (Exception e){
            Log.error("caught and exception {}",e);
        }


    }
}