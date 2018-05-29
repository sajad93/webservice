package ir.appete.test.webservice.service.interfaces;


import ir.appete.test.webservice.persistant.entity.ProfileEntity;
import ir.appete.test.webservice.persistant.entity.UserEntity;

/*
 * Created by  sajad on 5/29/18
 */
public interface UserService {

    void createUser(UserEntity user);

    UserEntity readUser(int id);

    void updateUser(UserEntity user);

    void deleteUser(UserEntity user);

    void createProfile(ProfileEntity profile);

    ProfileEntity readProfile(int id);

    void updateProfile(ProfileEntity profile);

    void deleteProfile(ProfileEntity profile);

    UserEntity readUserByUsername(String username);
}
