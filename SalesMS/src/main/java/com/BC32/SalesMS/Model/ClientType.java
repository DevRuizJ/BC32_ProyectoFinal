package com.BC32.SalesMS.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "clientType")
@ToString
public class ClientType {

    @Id
    private Integer idClientType;

    private String name;
}
