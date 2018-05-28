package org.polytech.repository;

import org.polytech.business.Comment;
import org.polytech.business.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {

    List<Comment> findAllByPost(Post post);

}
