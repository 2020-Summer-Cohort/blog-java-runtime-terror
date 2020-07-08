package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.entities.Category;
import org.wcci.blog.storage.repositories.CategoryRepository;

import java.util.Optional;

@Service
public class CategoryStorage {
    private CategoryRepository categoryRepo;

    public CategoryStorage(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public Category findCategoryByName(String categoryName) {
        return categoryRepo.findByName(categoryName);
    }

    public Iterable<Category> findAllCategories() {
        return categoryRepo.findAll();
    }

    public void saveNewCategory(Category categoryToAdd) {
        categoryRepo.save(categoryToAdd);
    }

    public Category getSingleCategory(Long categoryId) {
        Optional<Category> categoryOptional = categoryRepo.findById(categoryId);
        Category foundCategory;
        foundCategory = categoryOptional.get();
        return foundCategory;
    }
}
