package org.wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.blog.entities.BlogPost;
import org.wcci.blog.entities.Category;
import org.wcci.blog.storage.repositories.BlogPostRepository;
import org.wcci.blog.storage.repositories.CategoryRepository;

@Component
public class Populator implements CommandLineRunner  {
    @Autowired
    CategoryRepository categoryRepo;
    @Autowired
    BlogPostRepository blogPostRepo;

    @Override
    public void run(String... args) throws Exception {
        Category generalDiscussion = new Category("General Discussion");
        Category mvpRace = new Category("MVP Race");
        categoryRepo.save(generalDiscussion);
        categoryRepo.save(mvpRace);
        BlogPost blogPost1 = new BlogPost("Best Team", "Derek Mosher", generalDiscussion, "Cavs are the best team out there right now.");
        blogPostRepo.save(blogPost1);
    }
}
