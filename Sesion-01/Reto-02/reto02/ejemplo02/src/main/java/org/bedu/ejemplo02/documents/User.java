package org.bedu.ejemplo02.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    private String id;

    private String username;
    private String email;
    private String Password;
    private Date createdAt;
    private Date updatedAt;
}
