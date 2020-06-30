package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.wcci.blog.storage.BlogPostStorage;

@Controller
public class BlogPostController {
    BlogPostStorage blogPostStorage;

    public BlogPostController(BlogPostStorage blogPostStorage) {
        this.blogPostStorage = blogPostStorage;
    }

    @GetMapping("blogPosts/{blogPostTitle}")
    public String showSingleBlogPost (@PathVariable String blogPostTitle, Model model) {
        model.addAttribute("blogPost", blogPostStorage.findBlogPostByTitle(blogPostTitle));
        return "blogpost-template";
    }


}
