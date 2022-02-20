package br.com.rodrigoeduque.app.productapi.service;

import br.com.rodrigoeduque.app.productapi.dto.CategoryDto;
import br.com.rodrigoeduque.app.productapi.model.Category;
import br.com.rodrigoeduque.app.productapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDto getCategoryById(Long id) {

        Optional<Category> category = categoryRepository.findById(id);

        if(category.isPresent()) {
            CategoryDto categoryDto = category.get().convertToDto();
            return categoryDto;
        }
        throw new RuntimeException("Categoria inexistente : " + id);
    }

    public List<CategoryDto> getCategoryAll() {

        List<Category> categorias = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = categorias.stream().map(Category::convertToDto).collect(Collectors.toList());
        return categoryDtos;
    }

    public void save(CategoryDto categoryDto) {

        Category category = categoryDto.convertToModel();
        categoryRepository.save(category);
    }

    public void deleteById(Long id) {

        CategoryDto categoryById = getCategoryById(id);

        categoryRepository.delete(categoryById.convertToModel());

    }

}
