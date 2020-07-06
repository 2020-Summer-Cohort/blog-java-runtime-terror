package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.entities.BlogPost;
import org.wcci.blog.storage.repositories.BlogPostRepository;

@Service
public class BlogPostStorage {
    BlogPostRepository blogPostRepo;

    public BlogPostStorage(BlogPostRepository blogPostRepo) {
        this.blogPostRepo = blogPostRepo;
    }

    public BlogPost findBlogPostByTitle(String blogPostTitle) {
        return blogPostRepo.findByTitle(blogPostTitle);
    }

    public Iterable<BlogPost> findAllBlogPosts() {
        return blogPostRepo.findAll();
    }

    public void saveNewBlogPost(BlogPost blogPostToSave) {
        blogPostRepo.save(blogPostToSave);
    }

}
