package ir.appete.test.webservice.persistant.entity;

import javax.persistence.*;

/*
 * Created by  sajad on 5/29/18
 */

@Entity
@Table(name = "user")
public class UserEntity {

    private int id;
    private String fullName;
    private String username;
    private String password;
    private ProfileEntity userProfile;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "user")

    public ProfileEntity getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(ProfileEntity userProfile) {
        this.userProfile = userProfile;
    }

//    @Override
//    public String toString() {
//        return "{fullName=" + fullName + ", username=" + username + ", password=" + password
//                + ", profile="
//                + userProfile + "}";
//    }
}
