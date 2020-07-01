package org.wcci.blog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    private String authorName;
    @OneToMany(mappedBy = "author")
    private Collection<BlogPost> blogPosts;

    protected Author() {
    }

    public Author(String authorName) {
        this.authorName = authorName;
    }

    public Long getId() {
        return id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public Collection<BlogPost> getBlogPosts() {
        return blogPosts;
    }
}
