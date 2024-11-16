package com.crud.cadastro.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    // Autowired cria a classe automaticamente (elimina a necessidade de dar new CustomerDAO...)
    @Autowired
    CustomerDAO cdao;

    public void insertCustomer(Customer cus){
        cdao.insertCustomer(cus);
    }

    public List<Customer> findAllCustomers() {
        return cdao.findAll();
    }

    public void updateCustomer(Customer cus) {
        cdao.updateCustomer(cus);
    }

    public void deleteCustomer(int id) {
        cdao.deleteCustomer(id);
    }
}