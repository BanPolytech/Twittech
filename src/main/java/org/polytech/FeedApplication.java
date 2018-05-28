package org.polytech;

import org.polytech.business.Comment;
import org.polytech.business.Heart;
import org.polytech.business.Post;
import org.polytech.business.User;
import org.polytech.repository.CommentRepository;
import org.polytech.repository.HeartRepository;
import org.polytech.repository.PostRepository;
import org.polytech.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class FeedApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeedApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PostRepository postRepository,
                                  UserRepository userRepository,
                                  CommentRepository commentRepository,
                                  HeartRepository heartRepository,
                                  PasswordEncoder passwordEncoder) {
		return (args) -> {
			// Add users
			User bob = new User("Bob", passwordEncoder.encode("123"));
			User alice = new User("Alice", passwordEncoder.encode("456"));
			userRepository.save(bob);
			userRepository.save(alice);

			// Add posts
			Post hello = new Post(bob, "Hello");
			postRepository.save(hello);
			postRepository.save(new Post(bob, "World !"));
			postRepository.save(new Post(alice, "Hey"));

			// Add comments
            commentRepository.save(new Comment(hello, alice, "Nice !"));

            // Add likes
            heartRepository.save(new Heart(hello, alice));
		};
	}
}
