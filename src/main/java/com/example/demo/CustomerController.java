package com.example.demo;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.entity.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private CustomerRepository repository;

    public CustomerController(CustomerRepository repository){
        super();
        this.repository = repository;
    }

    @PostMapping("/customer")
    public Customer postCustomer(Customer customer){
        return repository.save(customer);
    }

    @PutMapping("/customer")
    public Customer putCustomer(Customer customer){
        return repository.save(customer);
    }

    @DeleteMapping("/customer")
    public void deleteCustomer(int id){
        repository.deleteById(id);
    }

    @GetMapping("/customer")
    public Customer getCustomer(int id){
        return repository.findById(id).orElse(null);
        //return repository.findById(id).orElseThrow();
    }

    @GetMapping("/customer/name")
    public List<Customer> getCustomer(String name){
        return repository.findByName(name);
    }

    @GetMapping("/customer/search")
    public List<Customer> searchCustomer(String name){
        return repository.findByNameLike("%" + name + "%");
    }

    @GetMapping("/customer/vip")
    public List<Customer> searchVipCustomer(String name, int primaryContact){
        return repository.findVipList(name, primaryContact);
    }

    @GetMapping("/customer/list")
    public List<Customer> getCustomerList(){
        return (List<Customer>)repository.findAll();
    }
}
