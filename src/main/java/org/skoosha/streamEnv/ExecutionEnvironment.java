package org.skoosha.streamEnv;

import lombok.Getter;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;
@Getter
public class ExecutionEnvironment<T> {

    private final StreamExecutionEnvironment env;
    private final SourceFunction<T> function;

    public ExecutionEnvironment(SourceFunction<T> sourceFunction){
        env=StreamExecutionEnvironment.getExecutionEnvironment();
        function = sourceFunction;
    }

    private DataStreamSource<T> buildEnvironmentFromSource(){
         return env.addSource(function);
    }
    public DataStream<T> getDataStream(){
        return buildEnvironmentFromSource();
    }




}
