package com.springboot.aesencryption.service;

import com.springboot.aesencryption.pojo.DecodedDataRequest;
import com.springboot.aesencryption.pojo.DecodedDataResponse;
import com.springboot.aesencryption.pojo.EncodedDataRequest;
import com.springboot.aesencryption.pojo.EncodedDataResponse;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface EncryptionService {
    public EncodedDataResponse encrypt(EncodedDataRequest encodedDataRequest) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException;

    String decrypt(DecodedDataRequest decodedDataRequest) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException;
}
