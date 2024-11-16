package com.crud.cadastro.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

// DAO --> Data Acess Object: Serve para gerenciar o banco de dados
@Repository
public class CustomerDAO {
    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }

    public void insertCustomer(Customer cus){
        String sql = "INSERT into Customer(nm_customer, ds_email, password) Values (?,?,?)";
        jdbc.update(sql, cus.getNmCustomer(), cus.getDsEmail(), cus.getPassword() );
    }

      public List<Customer> findAll() {
        String sql = "SELECT cd_customer, nm_customer, ds_email, password FROM customer";
        return jdbc.query(sql, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Customer(
                    rs.getInt("cd_customer"),
                    rs.getString("nm_customer"),
                    rs.getString("password"),
                    rs.getString("ds_email")
                );
            }
        });
    }

    public void updateCustomer(Customer cus) {
        String sql = "UPDATE customer SET nm_customer = ?, ds_email = ?, password = ? WHERE cd_customer = ?";
        jdbc.update(sql, cus.getNmCustomer(), cus.getDsEmail(), cus.getPassword(), cus.getId());
    }
    
    public void deleteCustomer(int id) {
        String sql = "DELETE FROM customer WHERE cd_customer = ?";
        jdbc.update(sql, id);
    }
    
}