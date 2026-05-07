package com.mecaps.blogApp.concept.criteriaAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/search")
    public List<Products> search(@RequestParam(required = false) String name,
                                 @RequestParam(required = false) Double min,
                                 @RequestParam(required = false) Double max,
                                 @RequestParam(required = false) String category) {

                List<Products> search = productService.search(name, min, max, category);
                return search;
    }


//    http://localhost:8080/products/search?name=Laptop
    //http://localhost:8080/products/search?name=Laptop&category=Electronics&min=100&max=14000
}






// Swap alternative element in an Array

// for example arr [1,2,3,6,4,5] // suppose array length is even num.
// output -> [2,1,6,3,5,4] like that...










