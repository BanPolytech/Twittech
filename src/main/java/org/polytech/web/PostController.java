package org.polytech.web;

import org.polytech.business.Comment;
import org.polytech.business.Heart;
import org.polytech.business.Post;
import org.polytech.business.User;
import org.polytech.repository.CommentRepository;
import org.polytech.repository.HeartRepository;
import org.polytech.repository.PostRepository;
import org.polytech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    HeartRepository heartRepository;

    /*
     * Get
     */

    @GetMapping("/")
    public String index(Model model, Principal principal) {

        Iterable<Post> posts = postRepository.findAll();

        model.addAttribute("posts", posts);
        model.addAttribute("username", principal.getName());

        return "/feed";
    }

    @RequestMapping("/post/{id}")
    public String post(@PathVariable(value="id") Long id, Model model, Principal principal) {

        Post post = postRepository.findOne(id);
        List<Comment> comments = commentRepository.findAllByPost(post);
        List<Heart> hearts = heartRepository.findAllByPost(post);

        if (post == null) {
            return "redirect:/";
        }

        model.addAttribute("post", post);
        model.addAttribute("comments", comments);
        model.addAttribute("hearts", hearts);
        model.addAttribute("username", principal.getName());

        return "/post";
    }

    /*
     * Post
     */

    @PostMapping("/share")
    public String share(@RequestParam("content") String content, Principal principal) {

        User author = userRepository.findByName(principal.getName());

        postRepository.save(new Post(author, content));

        return "redirect:/";
    }

    @PostMapping("/comment/{id}")
    public String comment(@PathVariable(value = "id") Long id, @RequestParam("content") String content, Principal principal) {
        Post post = postRepository.findOne(id);
        User author = userRepository.findByName(principal.getName());

        if (post == null) {
            return "redirect:/";
        }

        commentRepository.save(new Comment(post, author, content));

        return "redirect:/post/" + id;
    }

    @PostMapping("/heart/{id}")
    public String heart(@PathVariable(value = "id") Long id, Principal principal) {
        Post post = postRepository.findOne(id);
        User author = userRepository.findByName(principal.getName());

        if (post == null) {
            return "redirect:/";
        }

        heartRepository.save(new Heart(post, author));

        return "redirect:/post/" + id;
    }
}
