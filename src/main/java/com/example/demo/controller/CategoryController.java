package com.example.demo.controller;

import com.example.demo.dto.response.ResponMessage;
import com.example.demo.model.Category;
import com.example.demo.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
@CrossOrigin
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping
    public ResponseEntity<?> getList(){
        List<Category> listCategory = categoryService.findAll();
        return new ResponseEntity<>(listCategory,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody Category category){
        if (category.getName().trim().equals("")){
            return new ResponseEntity<>(new ResponMessage("name_valid"), HttpStatus.NOT_FOUND);
        }
        categoryService.save(category);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Category category){
        return category == null? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(category);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateCategory(@PathVariable("id")Long id, @RequestBody Category category){
        Optional<Category> optionalCategory = categoryService.findById(id);
        if (!optionalCategory.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        category.setId(id);
        categoryService.save(category);
        return new ResponseEntity<>(new ResponMessage("Update success"),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Category category){
        if (category == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryService.deleteById(category.getId());
        return ResponseEntity.ok(new ResponMessage("delete"));
    }
}