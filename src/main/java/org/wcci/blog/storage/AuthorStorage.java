package org.wcci.blog.storage;


import org.springframework.stereotype.Service;
import org.wcci.blog.entities.Author;
import org.wcci.blog.storage.repositories.AuthorRepository;

@Service
public class AuthorStorage {
    private AuthorRepository authorRepo;

    public AuthorStorage(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    public Iterable<Author> findAllAuthors() { return authorRepo.findAll();}

    public Author findAuthorByAuthorName (String authorName) {return authorRepo.findByAuthorName(authorName);}

    public void addAuthor (Author authorToAdd) {authorRepo.save(authorToAdd);}
}
