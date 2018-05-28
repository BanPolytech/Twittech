package org.polytech.business;

import javax.persistence.*;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;
    private String content;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Comment> comments;

    @OneToMany
    private List<Heart> hearts;

    protected Post() {}

    public Post(User user, String content) {
        this.user = user;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Post[id=" + id + ", user=" + user + ", content=" + content + ", comments=" + comments + "]";
    }

}
