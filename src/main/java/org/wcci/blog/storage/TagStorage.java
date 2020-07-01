package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.entities.Tag;
import org.wcci.blog.storage.repositories.TagRepository;

@Service
public class TagStorage {
    private TagRepository tagRepo;

    public TagStorage(TagRepository tagRepo) {
        this.tagRepo = tagRepo;
    }

    public Iterable<Tag> findAllTags() { return tagRepo.findAll();}

    public Tag findTagByTagName (String tagName) {return tagRepo.findByTagName(tagName);}

    public void addTag (Tag tagToAdd) {tagRepo.save(tagToAdd);}
}
