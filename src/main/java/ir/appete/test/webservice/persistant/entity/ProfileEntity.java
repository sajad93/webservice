package ir.appete.test.webservice.persistant.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/*
 * Created by  sajad on 5/29/18
 */

@Entity
@Table(name = "profile")
public class ProfileEntity {

    private int id;
    private String address;
    private String info;
    private UserEntity user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
