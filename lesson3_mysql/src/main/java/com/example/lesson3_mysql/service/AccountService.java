package com.example.lesson3_mysql.service;

import com.example.lesson3_mysql.entities.Account;
import com.example.lesson3_mysql.repository.AccountRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Data
@Service
public class AccountService {
    private final Map<String, Long> sessionMap = new HashMap<>();
    @Autowired
    private AccountRepository accountRepository;

    private String changeMD5(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }

    public Account createAccount(String username, String password) {
        if (accountRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Account already exists");
        }
        String hashedPassword = changeMD5(password);
        Account account = new Account(username, hashedPassword, 1);
        return accountRepository.save(account);
    }

    public String login(String username, String password) {
        String hashedPassword = changeMD5(password);
        Account account = accountRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("Account not found"));

        if (!hashedPassword.equals(account.getPassword())) {
            throw new IllegalArgumentException("Wrong password");
        }
        String token = UUID.randomUUID().toString().replace("-", "").substring(0, 30);
        sessionMap.put(token, account.getId());
        return token;
    }

    @Transactional
    public void changePassword(String token, String newPassword) {

        Long accountId = sessionMap.get(token);

        if (accountId == null) {
            throw new IllegalArgumentException("Token không hợp lệ hoặc đã hết hạn");
        }
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy tài khoản"));
        account.setPassword(changeMD5(newPassword));
        accountRepository.save(account);
    }
}
