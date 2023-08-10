package com.springboot.aesencryption.pojo;

import lombok.Data;

@Data
public class EncodedDataResponse {
    private String encodedData;
    private String status;
    private String statusDesc;

}
