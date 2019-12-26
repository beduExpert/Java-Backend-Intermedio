package org.bedu.postworksone.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {

    @Id
    private String id;

    private Doctor doctor;

    @NotNull
    private Patient patient;

    @NotNull
    private Date createdAt;

    private List<Disease> diseases;

    @NotNull
    private List<MedicationDetail> medicationDetails;
}
