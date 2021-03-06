package com.example.exampleproject.controller;

import com.example.exampleproject.model.ProductReview;
import com.example.exampleproject.repository.ProductReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class ProductReviewController {

    private ProductReviewRepository productReviewRepository;

    @Autowired
    public ProductReviewController(ProductReviewRepository productReviewRepository) {
        this.productReviewRepository = productReviewRepository;
    }

    @GetMapping("/productReview")
    public String findAll(Model model) {
        List<ProductReview> productReviews = productReviewRepository.findAll();
        model.addAttribute("productReviews", productReviews);
        return "product-review";
    }
//    @PostMapping(value = "/addReview", produces = {MediaType.APPLICATION_JSON_VALUE})
//    @ResponseBody
//    public ProductReviewResponse saveReview(@ModelAttribute @Valid ProductReview productReview,
//                                        BindingResult result) {
//
//        ProductReviewResponse response = new ProductReviewResponse();
//
//        if (result.hasErrors()) {
//
//            Map<String, String> errors = result.getFieldErrors().stream()
//                    .collect(
//                            Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
//                    );
//
//            response.setValidated(false);
//            response.setErrorMessages(errors);
//        } else {
//
//            response.setValidated(true);
//        }
//        return response;
//    }
//
//


//    @RequestMapping(value = "/product/{id}/add-review", method = RequestMethod.POST)
//    public String addReview(@PathVariable("id") int id, Model model, BindingResult result, @Valid ProductReview pr) {
//        productReviewRepository.save(pr);
//        return "redirect:/product" + id;
//    }
//    @GetMapping("/product/{id}/")
//    public String showUpdateForm(@PathVariable("id") int id, Model model) {
//        ProductReview pr = productReviewRepository.findById(id).get();
//        model.addAttribute("productReview", pr);
//        return "redirect:/product" + id;
//    }
//    @RequestMapping(value = "/product/{id}/edit-review", method = RequestMethod.POST)
//    public String editReview(@PathVariable("id") int id, Model model, BindingResult result, @Valid ProductReview pr) {
//        productReviewRepository.save(pr);
//        return "redirect:/product" + id;
//    }



}
