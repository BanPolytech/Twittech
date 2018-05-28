package org.polytech.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Heart {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User user;

    protected Heart() {}

    public Heart(Post post, User user) {
        this.post = post;
        this.user = user;
    }

}
