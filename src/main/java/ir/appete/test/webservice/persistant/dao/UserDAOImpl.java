package ir.appete.test.webservice.persistant.dao;

import ir.appete.test.webservice.persistant.entity.ProfileEntity;
import ir.appete.test.webservice.persistant.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/*
 * Created by  sajad on 5/29/18
 */
@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createUser(UserEntity user) {
        entityManager.persist(user);
    }

    @Override
    public UserEntity readUser(int id) {
        return entityManager.find(UserEntity.class,id);
    }

    @Override
    public void updateUser(UserEntity user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(UserEntity user) {
        entityManager.remove(user);
    }

    @Override
    public void createProfile(ProfileEntity profile) {
        entityManager.persist(profile);
    }

    @Override
    public ProfileEntity readProfile(int id) {
        return entityManager.find(ProfileEntity.class,id);
    }

    @Override
    public void updateProfile(ProfileEntity profile) {
        entityManager.merge(profile);
    }

    @Override
    public void deleteProfile(ProfileEntity profile) {
        entityManager.remove(profile);
    }

    @Override
    public UserEntity readUserByUsername(String username) {
        UserEntity user=(UserEntity) entityManager.createQuery("FROM UserEntity u WHERE  u.username = :username")
                .setParameter("username", username).getSingleResult();
        return user;
    }
}
