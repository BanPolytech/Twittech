package org.polytech.repository;

import org.polytech.business.Heart;
import org.polytech.business.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HeartRepository extends CrudRepository<Heart, Long> {

    List<Heart> findAllByPost(Post post);

}
