package org.bedu.postworksone.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicationDetail {

    @Id
    String id;

    @NotNull
    private Medicament medicament;

    @NotNull
    private Integer Days;

    @NotNull
    private Integer timeIntervals;

    @NotNull
    private String quantity;
}
