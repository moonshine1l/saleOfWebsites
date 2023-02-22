package ru.moonshine1l.saleOfWebsites.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.moonshine1l.saleOfWebsites.models.Product;
import ru.moonshine1l.saleOfWebsites.rep.ProductRepository;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/description")
        public String description(Model model){

        return "product_description";
    }
}
