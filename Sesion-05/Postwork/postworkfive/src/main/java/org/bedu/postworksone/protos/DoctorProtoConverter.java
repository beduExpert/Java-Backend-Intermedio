package org.bedu.postworksone.protos;

import lombok.experimental.UtilityClass;
import org.bedu.postworksone.documents.Doctor;
import org.bedu.postworksone.protos.models.DoctorProto;

@UtilityClass
public class DoctorProtoConverter {
    public DoctorProto.Doctor from(Doctor doctor) {
        DoctorProto.Doctor.Builder builder = DoctorProto.Doctor.newBuilder();

        builder.setId(doctor.getId())
                .setName(doctor.getName())
                .setLastname(doctor.getLastname())
                .setBirthday(doctor.getBirthday().toString())
                .setSpecialized(doctor.isSpecialized())
                .setYearsExperience(doctor.getYearsExperience());

        if (doctor.isSpecialized() && !doctor.getSpeciality().isBlank()) {
            builder.setSpeciality(doctor.getSpeciality());
        }

        return builder.build();
    }
}
