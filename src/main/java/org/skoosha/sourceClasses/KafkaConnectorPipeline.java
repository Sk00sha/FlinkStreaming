package org.skoosha.sourceClasses;



import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;


public class KafkaConnectorPipeline {

    public KafkaSource<String> buildKafkaSource(){
        KafkaSource<String> source = KafkaSource.<String>
                builder()
                .setBootstrapServers("localhost:9092")
                .setTopics("flinktopic")
                .setStartingOffsets(OffsetsInitializer.earliest())
                .setGroupId("Flink-group")
                .setValueOnlyDeserializer(new SimpleStringSchema())
                .build();

        return source;

    }

}
