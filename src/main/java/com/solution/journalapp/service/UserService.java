package com.solution.journalapp.service;

import com.solution.journalapp.entity.User;
import com.solution.journalapp.repository.UserRepository;
import com.solution.journalapp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveEntry(User user) {
        userRepository.save(user);

    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> findEntryById(ObjectId id){
        return userRepository.findById(id);
    }

    public void deleteEntryById(ObjectId id){
        userRepository.deleteById(id);
    }

    public void updateEntryById(ObjectId id, User user){
        user.setId(id);
        userRepository.save(user);
    }

    public User findByUserName(String username){
        return userRepository.findByUsername(username);
    }
}
