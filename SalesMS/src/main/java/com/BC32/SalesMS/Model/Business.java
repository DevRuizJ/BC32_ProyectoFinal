package com.BC32.SalesMS.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document
@ToString
public class Business {

    @Id
    private Integer idBusiness;

    private String businessName;

    private String tradeName;

    private DocumentType documentType;

    private String documentNumber;

    private String contactPhone;
}
