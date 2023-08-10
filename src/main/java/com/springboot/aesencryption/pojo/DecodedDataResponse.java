package com.springboot.aesencryption.pojo;

import lombok.Data;

@Data
public class DecodedDataResponse {

    private String decodedDataInString;
    private byte[] decodedDataInByte;
    private String status;
    private String statusDesc;
}
