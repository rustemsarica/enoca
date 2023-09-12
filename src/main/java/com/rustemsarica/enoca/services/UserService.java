package com.rustemsarica.enoca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rustemsarica.enoca.models.User;
import com.rustemsarica.enoca.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository uRepository;

    public User getUser(long id){
        return uRepository.findById(id).get();
    }
    
    public User save(User user){
        return uRepository.save(user);
    }

    public ResponseEntity<?> delete(long userId) {
        uRepository.delete(getUser(userId));
        return ResponseEntity.ok("User deleted");
    }

    public List<User> getUsers() {
        return uRepository.findAll();
    }

}
