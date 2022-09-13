package com.BC32.ProductMS.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document
@ToString
public class ProductType {

	@Id
	private Integer idProductType;

    private String name;
}
