package org.polytech.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String hash;

    //@OneToMany
    //List<Post> posts;

    protected User() {}

    public User(String name, String hash) {
        this.name = name;
        this.hash = hash;
    }

    public String getName() {
        return name;
    }

    public String getHash() {
        return hash;
    }

    @Override
    public String toString() {
        return "User[id=" + id + ", name=" + name + ", hash" + hash + "]";
    }

}
