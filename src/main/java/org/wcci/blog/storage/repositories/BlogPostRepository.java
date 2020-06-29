package org.wcci.blog.storage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.entities.BlogPost;

public interface BlogPostRepository extends CrudRepository<BlogPost, Long> {

    BlogPost findByTitle (String blogPostTitle);
}
