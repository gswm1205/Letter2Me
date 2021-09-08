package com.example.lettertome.controller;

import com.example.lettertome.model.entity.User;
import com.example.lettertome.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController{
    @Autowired
    private UserService userService;

//    @PostMapping
//    public void create(@RequestBody User user){
//        userService.create(user);
//    }

    @PostMapping
    public void signup(@RequestBody User user){
        //logger.info("this is request : " + request.getParameter("id"));

//        User user = new User();
//        user.setId(request.getParameter("id"));
//        user.setPassword(request.getParameter("password"));
//        user.setEmail(request.getParameter("email"));
        try {
            userService.create(user);
        }catch (Exception e) {
            log.info("test" + e);
        }

    }

    @PostMapping("/signin")
    public User signin(@RequestBody User user) {
        String id = user.getId();
        String password=user.getPassword();

        Logger logger = LoggerFactory.getLogger(UserController.class);
        User newUser = new User();
        newUser = userService.get(id);

        if (newUser == null) {
            return null;
        } else if (id.equals(newUser.getId()) && password.equals(newUser.getPassword())) {
//            String jwtString = Jwts.builder()
//                    //.setHeaderParam("id", user.getId())
//                    .setSubject(user.getId().toString())
//                    .signWith(SignatureAlgorithm.HS512, "aaaa")
//                    .compact();
//
//            logger.info("this is token : " + jwtString);
            return newUser;
        }else{
            return null;
        }
    }

    @PostMapping("/resetpassword")
    public User resetpassword(@RequestBody User user) {
        String id = user.getId();
        String email=user.getEmail();

        Logger logger = LoggerFactory.getLogger(UserController.class);
        User newUser = new User();
        newUser = userService.get(id);

        if (newUser == null) {
            return null;
        } else if (id.equals(newUser.getId()) && email.equals(newUser.getEmail())) {
            newUser.setPassword("1234");
            userService.resetPassword(newUser);
            return user;
        }else{
            return null;
        }
    }




    @GetMapping
    public List<User> get(){
        return userService.list();
    }


    @GetMapping("/{id}")
    public User get(@PathVariable String id){return userService.get(id);}

    @PutMapping
    public User update(@RequestBody User user) {
        Logger logger = LoggerFactory.getLogger(UserController.class);
        logger.info("is it okay?");
        logger.info("this is update user : " + user);
        return userService.update(user);
    }


    @DeleteMapping("/{number}")
    public void delete(@PathVariable Long number) {userService.delete(number); }
}
