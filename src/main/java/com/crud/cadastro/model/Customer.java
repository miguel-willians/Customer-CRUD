package com.crud.cadastro.model;

// Classes que moldam os dados necessários para o banco

public class Customer {
    private int id;
    private String nmCustomer, password, dsEmail;


    // Sobrecarga - Tela de cadastro
    public Customer(){
        
    }

    // Sobrecarga - Inserir registro
    public Customer(String nmCustomer, String password, String dsEmail){
        this.nmCustomer = nmCustomer;
        this.password = password;
        this.dsEmail = dsEmail;
    }

    public Customer(int id, String nmCustomer, String password, String dsEmail){
        this.id = id;
        this.nmCustomer = nmCustomer;
        this.password = password;
        this.dsEmail = dsEmail;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNmCustomer() {
        return nmCustomer;
    }

    public void setNmCustomer(String nmCustomer) {
        this.nmCustomer = nmCustomer;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    
}
