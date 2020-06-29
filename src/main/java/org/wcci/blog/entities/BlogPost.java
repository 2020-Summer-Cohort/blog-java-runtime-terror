package org.wcci.blog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BlogPost {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String author;
    private String postBody;
    @ManyToOne
    private Category category;

    protected BlogPost() {
    }

    public BlogPost(String title, String author, Category category, String postBody) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.postBody = postBody;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }

    public String getPostBody() {
        return postBody;
    }

    public long getId() {
        return id;
    }


}
