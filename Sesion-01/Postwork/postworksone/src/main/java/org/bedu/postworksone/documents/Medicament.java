package org.bedu.postworksone.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicament {

    @Id
    private String id;

    @NotEmpty
    @Length(min = 1, max = 100)
    private String name;

    @NotEmpty
    private String quantity;

    @NotNull
    private Date expirationDate;
}
