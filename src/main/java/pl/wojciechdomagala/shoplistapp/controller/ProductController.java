package pl.wojciechdomagala.shoplistapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.wojciechdomagala.shoplistapp.model.Product;
import pl.wojciechdomagala.shoplistapp.repository.ProductRepository;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public String listProduct(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("productList", products);
        return "list";
    }

    @PostMapping
    public String addProduct(@ModelAttribute Product productModel, RedirectAttributes redirectAttributes) {
        productRepository.save(productModel);
        redirectAttributes.addFlashAttribute("message", "Product and category added");
        return "redirect:/";
    }

}
