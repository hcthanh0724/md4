package com.example.account.controller;

import com.example.account.model.Account;
import com.example.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("")
    public String showHome(Model model){
        model.addAttribute("account",accountService.showList());
        return "home";
    }
    @GetMapping("/create")
    public String createAccount(Model model){
        model.addAttribute("account",new Account());
        return "create";
    }
    @PostMapping("/create")
    public String createAccount(@ModelAttribute Account account, @RequestParam MultipartFile imgFile) throws IOException {
        String name = imgFile.getOriginalFilename();
        FileCopyUtils.copy(imgFile.getBytes(), new File("D:/module 4/account/src/main/webapp/img/" + name));
        account.setAvatar("/"+name);
        accountService.addAccount(account);
        return "redirect: ";
    }

}
