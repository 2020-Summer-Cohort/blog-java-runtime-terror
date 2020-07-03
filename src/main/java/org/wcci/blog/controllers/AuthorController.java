package org.wcci.blog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.wcci.blog.entities.Author;
import org.wcci.blog.storage.AuthorStorage;

@Controller
public class AuthorController {
    AuthorStorage authorStorage;

    public AuthorController(AuthorStorage authorStorage) {
        this.authorStorage = authorStorage;
    }

    @GetMapping("all-authors")
    public String showAllAuthors(Model model) {
        model.addAttribute("authors", authorStorage.findAllAuthors());
        return "all-authors-template";
    }

    @GetMapping("author/{authorName}")
    public String showSingleAuthor(@PathVariable String authorName, Model model) {
        model.addAttribute("author", authorStorage.findAuthorByAuthorName(authorName));
        return "single-author-template";

    }

    @PostMapping("authors/add")
    public String addAuthor(String authorName) {
        Author authorToAdd = new Author(authorName);
        authorStorage.addAuthor(authorToAdd);
        return "redirect:/all-authors";

    }

}
