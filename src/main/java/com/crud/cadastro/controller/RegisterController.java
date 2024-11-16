package com.crud.cadastro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.cadastro.model.Customer;
import com.crud.cadastro.model.CustomerService;


@Controller
public class RegisterController {

        @Autowired
        ApplicationContext context;
        @GetMapping("/")
        public String index(){
            return "index";
        }

        @GetMapping("/register")
        public String register(Model model){
            Customer cus = new Customer();
            model.addAttribute("customer", cus);
            return "register";
        }

        @PostMapping("/register")
        public String sucess(@ModelAttribute Customer cus){
            CustomerService cs = context.getBean(CustomerService.class);
            cs.insertCustomer(cus);
            return "sucess";
        }


}
