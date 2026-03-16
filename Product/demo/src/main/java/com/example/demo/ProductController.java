package com.example.demo;

import java.util.List;

import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final MongoTemplate template;

    public ProductController(MongoTemplate template) {
        this.template = template;
    }

    @GetMapping("/products")
public List<Document> getProducts() {
    return template.findAll(Document.class, "products");
}

@GetMapping("/count")
public long count() {
    return template.getCollection("products").countDocuments();
}
}