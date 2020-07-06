package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.wcci.blog.storage.BlogPostStorage;

@Controller
public class BlogPostController {
    BlogPostStorage blogPostStorage;

    public BlogPostController(BlogPostStorage blogPostStorage) {
        this.blogPostStorage = blogPostStorage;
    }

    @GetMapping("blogPosts/{title}")
    public String showSingleBlogPost (@PathVariable String title, Model model) {
        model.addAttribute("blogPost", blogPostStorage.findBlogPostByTitle(title));
        return "single-blogpost-template";
    }

    @GetMapping ("all-blogposts")
    public String showAllBlogPosts (Model model) {
        model.addAttribute("blogPosts", blogPostStorage.findAllBlogPosts());
        return "all-blogposts-template";
    }

    @PostMapping ("blogPosts/add")
    public String


}
