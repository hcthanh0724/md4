package com.example.hybernate.controller;

import com.example.hybernate.model.Account;
import com.example.hybernate.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Controller

public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/signIn")
    public String signIn(Model model) {
        model.addAttribute("account", new Account());
        return "SignIn";
    }

    @PostMapping("/signIn")
    public String signIn(@Validated @ModelAttribute("account") Account account,BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            return "/SignIn";
        }
        else{
            Account account1 = accountService.findAccount(account);
            if(account1 != null){
                return "/accounts";
            }
            else {
                model.addAttribute("error","Invalid username or password");
                return "SignIn";
            }
        }
    }

    @GetMapping("accounts")
    public String getAll(Model model) {
//        List<Account> accounts = accountService.getAll();
        model.addAttribute("accounts", accountService.getAll());
        return "accounts";
    }

    @GetMapping("/create")
    public String createAccount(Model model) {
        model.addAttribute("accounts", new Account());
        return "create";
    }

    @PostMapping("/create")
    public String createAccount(@Validated @ModelAttribute ("accounts") Account account, BindingResult bindingResult, int idRole, @RequestParam MultipartFile imgFile) {
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            accountService.save(account, idRole, imgFile);
            return "redirect:/signIn";
        }

    }

    @GetMapping("/updateAccount")
    public String updateAccount(Model model) {
        model.addAttribute("account", new Object());
        return "edit";
    }
}
