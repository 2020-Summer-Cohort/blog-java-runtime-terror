package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.entities.Tag;
import org.wcci.blog.storage.repositories.TagRepository;

import java.util.Optional;

@Service
public class TagStorage {
    private TagRepository tagRepo;

    public TagStorage(TagRepository tagRepo) {
        this.tagRepo = tagRepo;
    }

    public Iterable<Tag> findAllTags() { return tagRepo.findAll();}

    public Tag findTagByTagName (String tagName) {return tagRepo.findByTagName(tagName);}

    public void addTag (Tag tagToAdd) {tagRepo.save(tagToAdd);}

    public Tag getSingleTag(Long singleTagId) {
        Optional<Tag> tagOptional = tagRepo.findById(singleTagId);
        Tag foundTag;
        foundTag = tagOptional.get();
        return foundTag;
    }
}
