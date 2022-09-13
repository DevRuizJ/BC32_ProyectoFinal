package com.BC32.SalesMS.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "client")
public class Client {

    @Id
    private Integer idClient;

    private ClientType clientType;

    private Person person;

    private Business business;
}
