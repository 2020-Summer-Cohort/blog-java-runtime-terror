package org.wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.blog.entities.Author;
import org.wcci.blog.entities.BlogPost;
import org.wcci.blog.entities.Category;
import org.wcci.blog.entities.Tag;
import org.wcci.blog.storage.repositories.AuthorRepository;
import org.wcci.blog.storage.repositories.BlogPostRepository;
import org.wcci.blog.storage.repositories.CategoryRepository;
import org.wcci.blog.storage.repositories.TagRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    CategoryRepository categoryRepo;
    @Autowired
    BlogPostRepository blogPostRepo;
    @Autowired
    AuthorRepository authorRepo;
    @Autowired
    TagRepository tagRepo;

    @Override
    public void run(String... args) throws Exception {
        Category generalDiscussion = new Category("General Discussion");
        Category mvpRace = new Category("MVP Race");
        Category playoffPicture = new Category("Playoff Picture");
        categoryRepo.save(generalDiscussion);
        categoryRepo.save(mvpRace);
        categoryRepo.save(playoffPicture);

        Author author1 = new Author("Julius Irving");
        Author author2 = new Author("Brian Windhorst");
        Author author3 = new Author("Johnny King");
        authorRepo.save(author1);
        authorRepo.save(author2);
        authorRepo.save(author3);

        Tag tag1 = new Tag("Beast");
        Tag tag2 = new Tag("Unstoppable");
        Tag tag3 = new Tag("Veteran");
        Tag tag4 = new Tag("Rebuilding");
        tagRepo.save(tag1);
        tagRepo.save(tag2);
        tagRepo.save(tag3);
        tagRepo.save(tag4);

        Collection<Tag> tagList1 = new ArrayList<>();
        tagList1.add(tag1);
        tagList1.add(tag3);

        Collection<Tag> tagList2 = new ArrayList<>();
        tagList2.add(tag2);
        tagList2.add(tag1);

        BlogPost blogPost1 = new BlogPost("Best Team- Cleveland Cavs", author2, LocalDateTime.now(), "Cavs are the best team out there right now. Collin Sexton and Kevin Love have been putting up some great numbers. I expect them to be in the finals.", generalDiscussion, tagList2);
        BlogPost blogPost2 = new BlogPost("Giannis A. for MVP", author1, LocalDateTime.now(), "Giannis is a monster. He is a great defender, scorer, and passer. Every game he amazes me. His size and athleticism is unmatched.", mvpRace, tagList1);

        blogPostRepo.save(blogPost1);
        blogPostRepo.save(blogPost2);
    }
}
