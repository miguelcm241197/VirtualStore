package pe.isil.isilweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.isilweb.model.Customer;
import pe.isil.isilweb.service.CustomerService;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public String getCustomerList(Model model){
        //list
        List<Customer> customers = customerService.getAll();
        model.addAttribute("customers", customers);
        return "customer";
    }

    @PostMapping("/customers/save")
    public String saveCustomer(Customer customer,
                              Model model){
        //save
        customerService.saveCustomer(customer);

        //list
        List<Customer> customers = customerService.getAll();
        model.addAttribute("customers", customers);
        return "customer";
    }

    @GetMapping("/customers/add")
    public String addCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "customer-add";
    }

    @GetMapping("/customers/edit/{codCli}")
    public String getCustomerForUpdate (@PathVariable String codCli,
                                       Model model){

        Customer currentCustomer = customerService.findById(codCli);
        model.addAttribute("customer", currentCustomer);
        return "customer-edit";
    }

    @PostMapping("/customers/update/{codCli}")
    public String updateCustomer(@PathVariable String codCli,
                                Customer customer,
                                Model model){

        //Update
        customerService.updateCustomer(customer);

        //list
        List<Customer> customers = customerService.getAll();
        model.addAttribute("customers", customers);
        return "customer";
    }

    @GetMapping("/customers/delete/{codCli}")
    public String deleteCustomer(@PathVariable String codCli,
                                Model model){

        Customer currentCustomer = customerService.findById(codCli);

        //Delete
        customerService.deleteCustomer(currentCustomer);

        //list
        List<Customer> customers = customerService.getAll();
        model.addAttribute("customers", customers);
        return "customer";
    }


}
