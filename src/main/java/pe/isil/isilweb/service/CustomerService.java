package pe.isil.isilweb.service;

import org.springframework.stereotype.Service;
import pe.isil.isilweb.model.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service

public class CustomerService {

    List<Customer> customers = new ArrayList<>(
            Arrays.asList(
                    new Customer("AAB01201",
                            "Fidel Juan",
                            "Castro",
                            "Gutierrez",
                            "fidelcas@gmail.com",
                            "Los Olivos",
                            "963847521"
                            ),
                    new Customer("AAB01202",
                            "Nicolas ",
                            "Arriola",
                            "Lopez",
                            "nicolas@gmail.com",
                            "Miraflores",
                            "987440023"
                            )
            )
    );

    public List<Customer> getAll(){
        return customers;
    }

    public void saveCustomer(Customer customer){
        customers.add(customer);
    }

    public void deleteCustomer(Customer customer){
        customers.remove(customer);
    }

    public void updateCustomer(Customer customer){
        Customer currentCustomer = findById(customer.getCodCli());
        int index = customers.indexOf(currentCustomer);
        customer.setCodCli(currentCustomer.getCodCli());
        customers.set(index, customer);
    }

    public Customer findById(String codCli){
        Customer customer = customers.stream()
                .filter(s -> s.getCodCli()
                        .equalsIgnoreCase(codCli))
                .findFirst()
                .orElseGet(null);
        return customer;
    }

}
