package org.bedu.ejemplo03.documents;

import lombok.*;
import org.bedu.ejemplo03.enums.Gender;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "students")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    @Id
    private String id;

    private User user;

    private String name;
    private String lastname;
    private Date birthdate;
    private String course;
    private Float weigth;
    private Float stature;
    private Gender gender;
}
