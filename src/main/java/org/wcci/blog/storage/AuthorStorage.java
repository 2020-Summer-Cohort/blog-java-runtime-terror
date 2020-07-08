package org.wcci.blog.storage;


import org.springframework.stereotype.Service;
import org.wcci.blog.entities.Author;
import org.wcci.blog.storage.repositories.AuthorRepository;

import java.util.Optional;

@Service
public class AuthorStorage {
    private AuthorRepository authorRepo;

    public AuthorStorage(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepo.findAll();
    }

    public Author findAuthorByAuthorName(String authorName) {
        return authorRepo.findByAuthorName(authorName);
    }

    public void addAuthor(Author authorToAdd) {
        authorRepo.save(authorToAdd);
    }

    public Author getSingleAuthor(Long authorId) {
        Optional<Author> authorOptional = authorRepo.findById(authorId);
        Author foundAuthor;
        foundAuthor = authorOptional.get();
        return foundAuthor;
    }
}
