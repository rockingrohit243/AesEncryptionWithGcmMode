package com.springboot.aesencryption.controller;

import com.springboot.aesencryption.pojo.DecodedDataRequest;
import com.springboot.aesencryption.pojo.DecodedDataResponse;
import com.springboot.aesencryption.pojo.EncodedDataRequest;
import com.springboot.aesencryption.pojo.EncodedDataResponse;
import com.springboot.aesencryption.service.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
public class EncryptionController {
    @Autowired
    private EncryptionService encryptionService;
    @PostMapping("encrypt")
private EncodedDataResponse encrypt(@RequestBody EncodedDataRequest encodedDataRequest) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
   return encryptionService.encrypt(encodedDataRequest);
}
@PostMapping("decrypt")
private String decrrypt(@RequestBody DecodedDataRequest decodedDataRequest) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
    return encryptionService.decrypt(decodedDataRequest);
}
}
