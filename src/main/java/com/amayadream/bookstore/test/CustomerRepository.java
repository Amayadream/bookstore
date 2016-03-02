package com.amayadream.bookstore.test;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2016.03.01 19:43
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByFirstName(String firstName);

    public List<Customer> findByLastName(String lastName);
}
