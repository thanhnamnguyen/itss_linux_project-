/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.secretnote.repository;

import com.secretnote.dao.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 *
 * @author HP
 */
public interface UserRepo extends MongoRepository<User, String> {
    // findBy + 1 attribute with correct name (except for first letter using case)
    Optional<User> findByUsername(String username);
}
