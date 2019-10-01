package pe.isil.isilweb.service;

import org.springframework.stereotype.Service;
import pe.isil.isilweb.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = new ArrayList<>(
            Arrays.asList(
                    new Product("A100","Zapatos Adidas","Calzado",25),
                    new Product("A101","Zapatillas Nike","Calzado",20)
            )
    );

    public List<Product> getAll(){
        return products;
    }

    public void saveProduct(Product product){
        products.add(product);
    }

    public void deleteProduct(Product product){
        products.remove(product);
    }

    public void updateProduct(Product product){
        Product currentProduct = findById(product.getCodProduct());
        int index = products.indexOf(currentProduct);
        product.setCodProduct(currentProduct.getCodProduct());
        products.set(index, product);
    }

    public Product findById(String codProduct){
        Product product = products.stream()
                .filter(s -> s.getCodProduct()
                        .equalsIgnoreCase(codProduct))
                .findFirst()
                .orElseGet(null);
        return product;
    }

}
