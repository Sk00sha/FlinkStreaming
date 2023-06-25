package org.skoosha.sourceClasses;



import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.serialization.SerializationSchema;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;

import java.util.Properties;

/**
 * Class used as Kafka connector admin
 * TODO add more robust param handling
 */
public class KafkaConnectorPipeline<T> {


    public KafkaConnectorPipeline(){}

    public KafkaSource<T> buildKafkaSource(Properties properties){
        KafkaSource<T> source = KafkaSource
                .<T>builder()
                .setProperties(properties)
                .build();

        return source;

    }

    public KafkaSource<T> buildKafkaSource(DeserializationSchema<T> schema){
        KafkaSource<T> source = KafkaSource
                .<T>builder()
                .setBootstrapServers("localhost:9092")
                .setTopics("flinktopic")
                .setStartingOffsets(OffsetsInitializer.earliest())
                .setGroupId("Flink-group")
                .setValueOnlyDeserializer(schema)
                .build();

        return source;

    }

}
