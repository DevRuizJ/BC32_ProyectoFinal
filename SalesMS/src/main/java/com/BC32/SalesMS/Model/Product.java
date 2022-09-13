package com.BC32.SalesMS.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "product")
public class Product {

	@Id
	private Integer idProduct;
	
    private String name;

	private String description;

	private ProductType productType;
}
