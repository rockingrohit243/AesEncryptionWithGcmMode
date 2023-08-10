package com.springboot.aesencryption;

import com.springboot.aesencryption.pojo.DecodedDataRequest;
import com.springboot.aesencryption.pojo.DecodedDataResponse;
import com.springboot.aesencryption.pojo.EncodedDataRequest;
import com.springboot.aesencryption.pojo.EncodedDataResponse;
import com.springboot.aesencryption.service.EncryptionService;
import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
public class EncryptionServiceImpl implements EncryptionService {
    Cipher encryptionCipher;
    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
    SecretKey key = keyGenerator.generateKey();

    public EncryptionServiceImpl() throws NoSuchAlgorithmException {
    }

    @Override
    public EncodedDataResponse encrypt(EncodedDataRequest encodedDataRequest) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        byte[] dataInByte = encodedDataRequest.getMessage().getBytes();
        encryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        encryptionCipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = encryptionCipher.doFinal(dataInByte);
        System.out.println("encrypted data is:" + encryptedBytes);
        EncodedDataResponse encodedDataResponse = new EncodedDataResponse();
        encodedDataResponse.setEncodedData(Base64.getEncoder().encodeToString(encryptedBytes));
        encodedDataResponse.setStatus("0");
        encodedDataResponse.setStatusDesc("successfully encrypted");
        return encodedDataResponse;
    }

    @Override
    public String decrypt(DecodedDataRequest decodedDataRequest) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        DecodedDataResponse decodedDataResponse=new DecodedDataResponse();
        byte[] dataInByte = Base64.getDecoder().decode(decodedDataRequest.getEncryptedData());
        Cipher decryptionCipher=Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec gcmParameterSpec=new GCMParameterSpec(128,encryptionCipher.getIV());

        decryptionCipher.init(Cipher.DECRYPT_MODE,key,gcmParameterSpec);
        byte[] decryptedByte=decryptionCipher.doFinal(dataInByte);
//        decodedDataResponse.setDecodedDataInByte(decryptedByte);
//        decodedDataResponse.setDecodedDataInString(decodedDataResponse.toString());
//        decodedDataResponse.setStatus("0");
//        decodedDataResponse.setStatusDesc("decrypted successfully");
//        return decodedDataResponse;
        return new String(decryptedByte);





    }

}

