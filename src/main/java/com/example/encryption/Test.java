package com.example.encryption;

import lombok.RequiredArgsConstructor;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Test {
   private final EncryptionConfig encryptionConfig;
   @GetMapping("/enc")
   private void enc() {
       String rawPassword = "password";
       StringEncryptor passwordEncryptor = encryptionConfig.getPasswordEncryptor();
       String encrypted = passwordEncryptor.encrypt(rawPassword);
       System.out.println(encrypted);
   }

    @GetMapping("/dec/{text}")
    private void dec(@PathVariable String text) {
        StringEncryptor passwordEncryptor = encryptionConfig.getPasswordEncryptor();
        String decrypted = passwordEncryptor.decrypt(text);
        System.out.println(decrypted);
    }
}
