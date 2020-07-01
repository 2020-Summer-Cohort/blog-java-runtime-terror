package org.wcci.blog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Entity
public class Tag {

    @Id
    @GeneratedValue
    private long id;
    private String tagName;
    @ManyToMany
    private Collection<BlogPost> blogPosts;

    protected Tag() {}

    public Tag(String tagName) {
        this.tagName = tagName;
    }

    public long getId() {
        return id;
    }

    public String getTagName() {
        return tagName;
    }

    public Collection<BlogPost> getBlogPosts() {
        return blogPosts;
    }
}
