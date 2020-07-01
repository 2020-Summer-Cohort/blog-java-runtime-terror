package org.wcci.blog.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
public class BlogPost {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    @ManyToOne
    private Author author;
    private LocalDateTime publishTime;
    private String postBody;
    @ManyToOne
    private Category category;
    @ManyToMany
    private Collection<Tag> tags;

    protected BlogPost() {
    }

    public BlogPost(String title, Author author, LocalDateTime publishTime, String postBody, Category category, Collection<Tag> tags) {
        this.title = title;
        this.author = author;
        this.publishTime = publishTime;
        this.postBody = postBody;
        this.category = category;
        this.tags = tags;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public LocalDateTime getPublishTime() {
        return publishTime;
    }

    public String getPostBody() {
        return postBody;
    }

    public Category getCategory() {
        return category;
    }

    public Collection<Tag> getTags() {
        return tags;
    }
}
