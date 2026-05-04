package com.mecaps.blogApp.concept;


import com.mecaps.blogApp.concept.criteriaAPI.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/criteria")
public class DemoCriteriaController {

    @Autowired
    private DemoCriteriaAPIClass demoCriteriaAPIClass;


    @GetMapping("/demo")
    public List<Products> getProducts(){
        return demoCriteriaAPIClass.getProducts();
    }
}
