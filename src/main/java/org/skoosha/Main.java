package org.skoosha;

import com.esotericsoftware.minlog.Log;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.skoosha.sourceClasses.KafkaConnectorPipeline;
import org.skoosha.streamEnv.ExecutionEnvironment;

public class Main {
    public static void main(String[] args)  {


        ExecutionEnvironment<Integer> env = new ExecutionEnvironment<>();

        try {
            //DataStream<Integer> stream = env.getGeneratorDataStream(new DataGenerator());
            DataStream<String> stream = env.createKafkaDataStream(new KafkaConnectorPipeline().buildKafkaSource());
            //DataStream<String> mappedStream = stream.map(HelperFunctions::evenOddDecider);
            stream.print();

            env.getEnv().execute("Starter job");
        }catch (Exception e){
            Log.error("caught and exception {}",e);
        }


    }
}