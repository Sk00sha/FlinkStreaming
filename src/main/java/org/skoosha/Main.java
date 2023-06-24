package org.skoosha;

import com.esotericsoftware.minlog.Log;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.skoosha.functions.HelperFunctions;
import org.skoosha.generator.DataGenerator;
import org.skoosha.streamEnv.ExecutionEnvironment;

public class Main {
    public static void main(String[] args)  {


        ExecutionEnvironment<Integer> env = new ExecutionEnvironment<>(new DataGenerator());

        try {
            DataStream<Integer> stream = env.getDataStream();

            DataStream<String> mappedStream = stream.map(HelperFunctions::evenOddDecider);
            mappedStream.print();

            env.getEnv().execute("Starter job");
        }catch (Exception e){
            Log.error("caught and exception {}",e);
        }


    }
}