package org.bedu.ejemplo03.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;
import java.util.Date;

@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    private String id;

    @Indexed(unique = true)
    @Length(min = 5, message = "el usuario requiere al menos 5 caracteres")
    private String username;

    @Indexed(unique = true)
    @Size(min = 6, message = "el email requiere al menos 6 caracteres")
    private String email;

    private String Password;
    private Date createdAt;
    private Date updatedAt;
}
