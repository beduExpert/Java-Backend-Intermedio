package org.bedu.ejemplo03.documents;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "instructors")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Instructor {
    @Id
    private String id;

    private User user;

    private String name;
    private String lastname;
    private String degree;

    @Getter(AccessLevel.NONE)
    private boolean certified;

    public boolean isCertified(){
        return this.certified;
    }
}
