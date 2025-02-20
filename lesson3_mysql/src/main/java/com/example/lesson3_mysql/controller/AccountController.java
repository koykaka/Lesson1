package com.example.lesson3_mysql.controller;

import com.example.lesson3_mysql.entities.*;
import com.example.lesson3_mysql.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<?> createAccount(@RequestParam String username, @RequestParam String password) {
        return ResponseEntity.ok(accountService.createAccount(username, password));
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        return ResponseEntity.ok(accountService.login(username, password));
    }

    @PutMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestParam String username, @RequestParam String newPassword) {
        accountService.changePassword(username, newPassword);
        return ResponseEntity.ok("Password changed successfully");
    }
}