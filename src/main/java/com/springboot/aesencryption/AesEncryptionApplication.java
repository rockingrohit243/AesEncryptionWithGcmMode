package com.springboot.aesencryption;

import io.unlogged.Unlogged;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AesEncryptionApplication {
@Unlogged
    public static void main(String[] args) {
        SpringApplication.run(AesEncryptionApplication.class, args);
    }

}
