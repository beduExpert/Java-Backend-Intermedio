package com.example.demo.configuration;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@Configuration(proxyBeanMethods = false)
@EnableKafkaStreams
public class KafkaStreamConfiguration {

    private static final Logger log = LoggerFactory.getLogger(KafkaStreamConfiguration.class);

    @Bean
    public KStream<String, String> kstream(StreamsBuilder streamsBuilder) {

        KStream<String, String> stream = streamsBuilder.stream("bedu-msg", Consumed.with( Serdes.String(), Serdes.String()))
                .map((key, value) -> new KeyValue<String, String>(key, Integer.toString(value.length())));

        stream.to("bedu-msg-2", Produced.with(Serdes.String(), Serdes.String()));

        return stream;

    }

}
