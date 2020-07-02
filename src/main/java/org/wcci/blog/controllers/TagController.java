package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.wcci.blog.entities.Tag;
import org.wcci.blog.storage.TagStorage;

@Controller
public class TagController {
    TagStorage tagStorage;

    public TagController(TagStorage tagStorage) {
        this.tagStorage = tagStorage;
    }

    @GetMapping ("all-tags")
    public String showAllTags (Model model) {
        model.addAttribute("tags", tagStorage.findAllTags());
        return "all-tags-template";
    }

    @GetMapping ("tag/{tagName}")
    public String showSingleTag (@PathVariable String tagName, Model model ) {
        model.addAttribute("tag", tagStorage.findTagByTagName(tagName));
        return "single-tag-template";
    }

    @PostMapping ("tag/add")
    public String addTag (String tagName) {
        Tag tagToAdd = new Tag(tagName);
        tagStorage.addTag (tagToAdd);
        return "all-tags-template";
    }
}
