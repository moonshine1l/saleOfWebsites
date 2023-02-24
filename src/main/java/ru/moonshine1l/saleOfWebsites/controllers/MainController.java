package ru.moonshine1l.saleOfWebsites.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("home/{id}/payment")
    public String payment(@PathVariable(value = "id") long id, Model model){
        Optional<Product> post = productRepository.findById(id);
        ArrayList<Product> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "payment";
    }

    @GetMapping("home/{id}/payment/notification")
    public String notification(@PathVariable(value = "id") long id, Model model){
        Optional<Product> post = productRepository.findById(id);
        ArrayList<Product> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        Product delpost = productRepository.findById(id).orElseThrow();
        productRepository.delete(delpost);
        return "notification";
    }

//    @PostMapping("/notification")
//    public String delete(@PathVariable(value = "id") long id, Model model){
//        Product delpost = productRepository.findById(id).orElseThrow();
//        productRepository.delete(delpost);
//        return "redirect :/home";
//    }
}
