package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.wcci.blog.entities.Author;
import org.wcci.blog.entities.BlogPost;
import org.wcci.blog.entities.Category;
import org.wcci.blog.entities.Tag;
import org.wcci.blog.storage.AuthorStorage;
import org.wcci.blog.storage.BlogPostStorage;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.TagStorage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Controller
public class BlogPostController {
    BlogPostStorage blogPostStorage;
    AuthorStorage authorStorage;
    TagStorage tagStorage;
    CategoryStorage categoryStorage;

    public BlogPostController(BlogPostStorage blogPostStorage, AuthorStorage authorStorage, TagStorage tagStorage, CategoryStorage categoryStorage) {
        this.blogPostStorage = blogPostStorage;
        this.authorStorage = authorStorage;
        this.tagStorage = tagStorage;
        this.categoryStorage = categoryStorage;
    }

    @GetMapping("blogPosts/{title}")
    public String showSingleBlogPost(@PathVariable String title, Model model) {
        model.addAttribute("blogPost", blogPostStorage.findBlogPostByTitle(title));
        return "single-blogpost-template";
    }

    @GetMapping("all-blogposts")
    public String showAllBlogPosts(Model model) {
        model.addAttribute("blogPosts", blogPostStorage.findAllBlogPosts());
        model.addAttribute("categories", categoryStorage.findAllCategories());
        model.addAttribute("authors", authorStorage.findAllAuthors());
        model.addAttribute("tags", tagStorage.findAllTags());
        return "all-blogposts-template";
    }

    @PostMapping("blogPosts/add")
    public String addBlogPost(String title, String postBody, Long authorId, Long categoryId, Long... tagIds) {
        Author author = authorStorage.getSingleAuthor(authorId);
        Category category = categoryStorage.getSingleCategory(categoryId);

        Collection<Tag> tags = new ArrayList<>();
        Collection<Long> tagsIdsCollection = new ArrayList<>(Arrays.asList(tagIds));
        for (Long singleTagId : tagsIdsCollection) {
            Tag tag = tagStorage.getSingleTag(singleTagId);
            tags.add(tag);
        }

        BlogPost blogPostToSave = new BlogPost(title, author, LocalDateTime.now(), postBody, category, tags);
        blogPostStorage.saveNewBlogPost(blogPostToSave);
        return "redirect:/all-blogposts";

    }

}
