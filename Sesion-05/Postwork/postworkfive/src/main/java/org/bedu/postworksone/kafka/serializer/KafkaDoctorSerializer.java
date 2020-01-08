package org.bedu.postworksone.kafka.serializer;

import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;
import org.bedu.postworksone.documents.Doctor;
import org.bedu.postworksone.protos.DoctorProtoConverter;

import java.util.Map;

public class KafkaDoctorSerializer implements Serializer<Doctor> {

    @Override
    public byte[] serialize(String s, Doctor doctor) {

        return DoctorProtoConverter.from(doctor).toByteArray();
    }


    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        //Nothing to do, this serializer does not need extra configuration
    }

    @Override
    public byte[] serialize(String topic, Headers headers, Doctor data) {
        return DoctorProtoConverter.from(data).toByteArray();
    }

    @Override
    public void close() {
        //Nothing to do, this serializer does not need to release resources
    }
}
