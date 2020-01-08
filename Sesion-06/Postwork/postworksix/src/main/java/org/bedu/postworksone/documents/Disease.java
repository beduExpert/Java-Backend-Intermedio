package org.bedu.postworksone.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Disease {

    @Id
    private String id;

    @NotNull
    private String name;

    private List<String> aliases;

    private List<String> causes;

    @NotNull
    private List<String> symptoms;

    @NotNull
    private List<String> signs;
}
