package pe.isil.isilweb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

    private String codProduct;
    private String description;
    private String category;
    private Integer price;

}
