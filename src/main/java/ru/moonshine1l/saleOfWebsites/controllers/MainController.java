package ru.moonshine1l.saleOfWebsites.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.moonshine1l.saleOfWebsites.models.Product;
import ru.moonshine1l.saleOfWebsites.rep.ProductRepository;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/home")
    public String list(Model model){
        Iterable<Product> posts = productRepository.findAll();
        model.addAttribute("posts", posts);
        return "home";
    }

    @GetMapping("/home/{id}")
    public String description(@PathVariable(value = "id") long id, Model model){
        Optional<Product> post = productRepository.findById(id);
        ArrayList<Product> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "product_description";
    }
}
