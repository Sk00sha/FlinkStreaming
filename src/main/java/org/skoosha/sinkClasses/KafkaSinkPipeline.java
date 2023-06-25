package org.skoosha.sinkClasses;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.connector.base.DeliveryGuarantee;
import org.apache.flink.connector.kafka.sink.KafkaRecordSerializationSchema;
import org.apache.flink.connector.kafka.sink.KafkaSink;
import org.apache.kafka.common.serialization.StringSerializer;

/**
 * TODO try to generalize builder to create sink with a general object support
 * @param <T> - Type of Kafka Sink object
 */
public class KafkaSinkPipeline<T> {
    public KafkaSink<String> buildKafkaSink(){
        KafkaSink<String> kafkaSink = KafkaSink
                .<String>builder()
                .setBootstrapServers("localhost:9092")
                .setDeliveryGuarantee(DeliveryGuarantee.NONE)
                .setRecordSerializer(KafkaRecordSerializationSchema
                        .builder()
                        .setTopic("outputflink")
                        .setKeySerializationSchema(new SimpleStringSchema())
                        .setValueSerializationSchema(new SimpleStringSchema())
                        .build())
                .build();

        return kafkaSink;
    }
}
