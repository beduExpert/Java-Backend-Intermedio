package org.bedu.postworksone.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    private String id;

    @NotEmpty
    @Length(min = 2, max = 20)
    private String name;

    @NotEmpty
    @Length(min = 2, max = 20)
    private String lastname;

    @NotEmpty
    private Date birthday;

    @Size(min = 30, max = 250)
    private Float stature;

    @Size(min = 30, max = 250)
    private Float weigth;
}
