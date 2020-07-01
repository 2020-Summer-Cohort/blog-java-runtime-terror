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
        BlogPost blogPost1 = new BlogPost("Best Team- Cleveland Cavs", "Derek Mosher", generalDiscussion, "Cavs are the best team out there right now.");
        BlogPost blogPost2 = new BlogPost("Lebron for MVP", "Brian Windhorst", mvpRace, "Without doubt, LeBron James is the best player in basketball right now. No one else comes close. Giannis just is not at LeBron's level yet.");

        blogPostRepo.save(blogPost1);
        blogPostRepo.save(blogPost2);
    }
}
