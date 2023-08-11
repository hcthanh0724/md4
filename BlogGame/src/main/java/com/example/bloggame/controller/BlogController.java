package com.example.bloggame.controller;

import com.example.bloggame.DAO.BlogDAO;
import com.example.bloggame.model.Blog;
import com.example.bloggame.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/home")
    public String showHome(Model model){
        model.addAttribute("blog",blogService.showHome());
        return "home";
    }
    @GetMapping("/detail")
    public String showDetail(@RequestParam int id_post, Model model){
        model.addAttribute("detail",blogService.selectBlog(id_post));
        return "detail";
    }
    @GetMapping("/addBlog")
        public String addBlog(){
        return "create";
    }
    @PostMapping("/addBlog")
    public String addBlog(@ModelAttribute Blog blog){
        blogService.addBlog(blog);
        return "redirect:/home";
    }
    @GetMapping("/editBlog")
    public String editBlog(@RequestParam int id_post,Model model){
        model.addAttribute("blog",blogService.findById(id_post));
        return "edit";
    }
    @PostMapping("editBlog")
    public String editBlog( @ModelAttribute Blog blog){
        blogService.editBlog(blog);
        return "redirect:/home";
    }
    @GetMapping("/deleteBlog")
    public String deleteBlog(@RequestParam int id_post) throws SQLException {
            blogService.deleteBlog(id_post);
            return "redirect:/home";
    }
    @GetMapping("/search")
    public String search(@RequestParam String header1,Model model){
        model.addAttribute("blog",blogService.search(header1));
        return "/home";
    }
}
