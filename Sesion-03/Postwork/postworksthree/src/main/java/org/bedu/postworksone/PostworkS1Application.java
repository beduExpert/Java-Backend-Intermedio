package org.bedu.postworksone;

import lombok.RequiredArgsConstructor;
import org.bedu.postworksone.documents.*;
import org.bedu.postworksone.repositories.*;
import org.bedu.postworksone.services.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PostworkS1Application implements CommandLineRunner {

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private final PrescriptionRepository prescriptionRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final DiseaseRepository diseasesRepository;
    private final MongoTemplate mongoTemplate;
    private final MedicamentRepository medicamentRepository;
    private final MedicationDetailRepository medicationDetailRepository;
    private final MappingService mappingService;

    public static void main(String[] args) {
        SpringApplication.run(PostworkS1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        mongoTemplate.dropCollection(Prescription.class);
        mongoTemplate.dropCollection(MedicationDetail.class);
        mongoTemplate.dropCollection(Disease.class);
        mongoTemplate.dropCollection(Patient.class);
        mongoTemplate.dropCollection(Doctor.class);

        mappingService.mappingPatient();

        Doctor doctor = new Doctor(null, "Diana Laura", "García", new SimpleDateFormat(DATE_FORMAT).parse("1995-09-12"), false, null, 1);
        doctor = doctorRepository.save(doctor);

        Patient patient = new Patient(null, "Alfredo", "Hernandez", new SimpleDateFormat(DATE_FORMAT).parse("1990-02-15"), 163f, 172f);
        patient = patientRepository.save(patient);

        Disease disease = new Disease(null, "Flu", null, Arrays.asList("Human contact"), Arrays.asList("cough", "distemper"), Arrays.asList("distemper", "redness of the area around the eyes"));
        disease = diseasesRepository.save(disease);

        List<Disease> diseases = new ArrayList<>(1);
        diseases.add(disease);

        Medicament medicament = new Medicament(null, "paracetamol", "100 mg =1ml = 25 drops", new SimpleDateFormat(DATE_FORMAT).parse("2025-02-10"));
        medicament = medicamentRepository.save(medicament);

        MedicationDetail medicationDetail = new MedicationDetail(null, medicament, 7, 8, "5 drops");
        medicationDetail = medicationDetailRepository.save(medicationDetail);

        List<MedicationDetail> medicationDetails = new ArrayList<>(1);
        medicationDetails.add(medicationDetail);

        Prescription prescription = new Prescription(null, doctor, patient, new Date(), diseases, medicationDetails);
        prescriptionRepository.save(prescription);

    }
}
