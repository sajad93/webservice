package ir.appete.test.webservice.controller;

import ir.appete.test.webservice.persistant.entity.ProfileEntity;
import ir.appete.test.webservice.persistant.entity.UserEntity;
import ir.appete.test.webservice.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/*
 * Created by  sajad on 5/29/18
 */

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/readUser/{id}")
    @ResponseBody
    public UserEntity readUser(@PathVariable int id) {
        return userService.readUser(id);
    }

    @DeleteMapping("/admin/deleteUser/{id}")
    public void deleteUser(@PathVariable int id,Principal principal) {
        userService.deleteUser(userService.readUser(id));
    }

    @GetMapping("/admin/readProfile/{id}")
    @ResponseBody
    public ProfileEntity readProfile(@PathVariable int id) {
        return userService.readProfile(id);
    }

    @DeleteMapping("/admin/deleteProfile/{id}")
    public void deleteProfile(@PathVariable int id,Principal principal) {
        userService.deleteProfile(userService.readProfile(id));
    }

    @PutMapping("/admin/updateUser/{id}")
    @ResponseBody
    public void updateUser(@PathVariable int id,@RequestBody UserEntity user,Principal principal) {
        UserEntity userEntity=userService.readUserByUsername(principal.getName());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        ProfileEntity profile=user.getUserProfile();
        if( userEntity.getUserProfile()!=null)
        user.getUserProfile().setId(userEntity.getUserProfile().getId());
        profile.setUser(user);
        user.setId(id);
        userService.updateUser(user);
    }


    @PutMapping("/admin/updateProfile/{id}")
    @ResponseBody
    public void updateProfile(@PathVariable int id,@RequestBody ProfileEntity profile,Principal principal) {
        profile.setUser(userService.readUserByUsername(principal.getName()));
        profile.setId(profile.getId());
        userService.updateProfile(profile);
    }

    @PostMapping("/user/signUp")
    @ResponseStatus
    @ResponseBody
    public String createUser(@RequestBody UserEntity user) {
        try{
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userService.createUser(user);
            return "{\"result\":\"ok\"}";
        }catch (Exception e){
            return "{\"result\":\"error\"}";
        }
    }

    @PostMapping("/user/addProfile")
    @ResponseBody
    public void addProfile(@RequestBody ProfileEntity profile) {

        userService.createProfile(profile);
    }
}