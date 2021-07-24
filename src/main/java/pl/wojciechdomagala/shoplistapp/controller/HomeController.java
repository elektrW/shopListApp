package pl.wojciechdomagala.shoplistapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.wojciechdomagala.shoplistapp.model.Product;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("productModel", new Product());
        return "index";
    }

}
