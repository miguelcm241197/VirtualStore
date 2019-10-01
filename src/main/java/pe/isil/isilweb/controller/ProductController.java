package pe.isil.isilweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.isilweb.model.Product;
import pe.isil.isilweb.service.ProductService;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public String getProductList(Model model){
        //list
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "product";
    }

    @PostMapping("/products/save")
    public String saveCustomer(Product product,
                               Model model){
        //save
        productService.saveProduct(product);

        //list
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "product";
    }

    @GetMapping("/products/add")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "product-add";
    }

    @GetMapping("/products/edit/{codProduct}")
    public String getProductForUpdate (@PathVariable String codProduct,
                                        Model model){

        Product currentProduct = productService.findById(codProduct);
        model.addAttribute("product", currentProduct);
        return "product-edit";
    }

    @PostMapping("/customers/update/{codProduct}")
    public String updateProduct(@PathVariable String codProduct,
                                 Product product,
                                 Model model){

        //Update
        productService.updateProduct(product);

        //list
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "product";
    }

    @GetMapping("/customers/delete/{codProduct}")
    public String deleteProduct(@PathVariable String codProduct,
                                 Model model){

        Product currentProduct = productService.findById(codProduct);

        //Delete
        productService.deleteProduct(currentProduct);

        //list
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "product";
    }

}
