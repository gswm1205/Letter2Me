package com.example.lettertome.service;

import com.example.lettertome.controller.UserController;
import com.example.lettertome.model.entity.User;
import com.example.lettertome.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> list() {
        List<User> result=(List<User>) userRepository.findAll();
        return result;
    }

    public void create(User user) {
        userRepository.save(user);
    }

    public User get(String id) {
        if(userRepository.existsById(id)) {
            return userRepository.findById(id).orElse(null);
        }else {
            Logger logger = LoggerFactory.getLogger(UserController.class);
            logger.info("this is false!");
            return null;
        }
//       return userRepository.findById(number).orElse(null);
    }

    public User resetPassword(User user){
        return userRepository.save(user);
    }

    public User update(User user) {
        User numberUser = userRepository.findByUserIdx(user.getUserIdx()).orElse(null);
        if(user.getPassword().equals(numberUser.getPassword())) {
            if(!user.getNewpassword().equals("")) {
                user.setPassword(user.getNewpassword());
            }
            user.setEmail(user.getEmail());
            userRepository.save(user);
            return user;
        }else{
            return null;
        }
    }

    public void delete(Long number) {
        userRepository.deleteById(number);
    }
}
