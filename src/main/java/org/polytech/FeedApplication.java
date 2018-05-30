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

}
