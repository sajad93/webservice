package ir.appete.test.webservice.service;

import ir.appete.test.webservice.persistant.dao.UserDAO;
import ir.appete.test.webservice.persistant.entity.ProfileEntity;
import ir.appete.test.webservice.persistant.entity.UserEntity;
import ir.appete.test.webservice.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/*
 * Created by  sajad on 5/29/18
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void createUser(UserEntity user){
        userDAO.createUser(user);
    }

    public UserEntity readUser(int id){
        return userDAO.readUser(id);
    }

    @Override
    public void updateUser(UserEntity user){
        userDAO.updateUser(user);
    }

    @Override
    public void deleteUser(UserEntity user){
        userDAO.deleteUser(user);
    }

    @Override
    public void createProfile(ProfileEntity profile) {
        userDAO.createProfile(profile);
    }

    @Override
    public ProfileEntity readProfile(int id) {
        return userDAO.readProfile(id);
    }

    @Override
    public void updateProfile(ProfileEntity profile) {
        userDAO.updateProfile(profile);
    }

    @Override
    public void deleteProfile(ProfileEntity profile) {
        userDAO.deleteProfile(profile);
    }

    @Override
    public UserEntity readUserByUsername(String username) {
        return userDAO.readUserByUsername(username);
    }
}