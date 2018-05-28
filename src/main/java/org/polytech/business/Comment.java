package org.polytech.business;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;
    private String content;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User user;

    protected Comment() {}

    public Comment(Post post, User user, String content) {
        this.post = post;
        this.user = user;
        this.content = content;
    }

    public Post getPost() {
        return post;
    }

    public String getContent() {
        return content;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Comment[id=" + id +", content=" + content + "]";
    }
}
