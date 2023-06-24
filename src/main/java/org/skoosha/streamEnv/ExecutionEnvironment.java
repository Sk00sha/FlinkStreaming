package org.skoosha.streamEnv;

import lombok.Getter;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

/***
 * Class used for env maintenance and administration
 * @param <T> - specify type of environment we want to create(dataFormat generated)
 */
@Getter
public class ExecutionEnvironment<T> {

    private final StreamExecutionEnvironment env;


    public ExecutionEnvironment(){
        env=StreamExecutionEnvironment.getExecutionEnvironment();

    }

    public DataStream<T> createKafkaDataStream(KafkaSource<T> source){
        DataStream<T> data = env.fromSource(source, WatermarkStrategy.noWatermarks(),"myKafkaSource");
        return data;
    }
    public DataStream<T> getGeneratorDataStream(SourceFunction<T> sourceFunction){
        return env.addSource(sourceFunction);
    }




}
