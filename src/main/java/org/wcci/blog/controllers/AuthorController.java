package org.wcci.blog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.wcci.blog.storage.AuthorStorage;

@Controller
public class AuthorController {
    AuthorStorage authorStorage;

    public AuthorController(AuthorStorage authorStorage) {
        this.authorStorage = authorStorage;
    }



}
