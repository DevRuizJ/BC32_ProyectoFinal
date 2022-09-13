package com.BC32.ClientMS.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document
@ToString
public class Person {

    @Id
    private Integer idPerson;

    private String name;

    private String lastName;

    private String motherLastName;

    private DocumentType documentType;

    private String documentNumber;

    private String email;

    private String phone;
}
