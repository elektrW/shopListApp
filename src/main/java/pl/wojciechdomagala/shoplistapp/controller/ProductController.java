package pl.wojciechdomagala.shoplistapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.wojciechdomagala.shoplistapp.model.Product;
import pl.wojciechdomagala.shoplistapp.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String listProduct(Model model) {
        model.addAttribute("productList", productService.listProduct());
        return "list";
    }

    @PostMapping
    public String addProduct(@ModelAttribute Product productModel, RedirectAttributes redirectAttributes) {
        productService.addProduct(productModel);
        redirectAttributes.addFlashAttribute("message", "Product and category added");
        return "redirect:/";
    }

    @GetMapping("/productDelete/{id}")
    public String deleteProduct(@PathVariable (value = "id") long id) {
        this.productService.deleteProduct(id);
        return "redirect:/";
    }

}
