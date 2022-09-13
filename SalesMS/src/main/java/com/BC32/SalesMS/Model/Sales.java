package com.BC32.SalesMS.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "client_product")
public class Sales {

    @Id
    private Integer idCliPro;

    private Client client;

    private Product product;
}
