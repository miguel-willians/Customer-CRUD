package com.crud.cadastro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.cadastro.model.Customer;
import com.crud.cadastro.model.CustomerService;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public String listCustomers(Model model) {
        // Obtém os dados do serviço
        List<Customer> customers = customerService.findAllCustomers();

        // Adiciona os dados ao modelo para renderização
        model.addAttribute("customers", customers);

        return "customers"; // Nome do arquivo HTML em templates
    }

        // Página para editar um cliente
    @GetMapping("/customers/edit/{id}")
    public String editCustomer(@PathVariable int id, Model model) {
        Customer customer = customerService.findAllCustomers().stream()
                                          .filter(c -> c.getId() == id)
                                          .findFirst()
                                          .orElse(null);

        if (customer != null) {
            model.addAttribute("customer", customer);
            return "editCustomer"; // Criar um formulário em editCustomer.html
        } else {
            return "redirect:/customers"; // Se não encontrar, redireciona para a lista
        }
    }

    // Método para atualizar um cliente
    @PostMapping("/customers/update")
    public String updateCustomer(@ModelAttribute Customer customer) {
        customerService.updateCustomer(customer);
        return "redirect:/customers"; // Redireciona para a lista de clientes
    }

    // Método para deletar um cliente
    @GetMapping("/customers/delete/{id}")
    public String deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers"; // Redireciona para a lista de clientes
    }
}

