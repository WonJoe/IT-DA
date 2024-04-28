package com.itda.dto;

import lombok.Data;

@Data
public class LocationSelectedDTO {
    
    private Long id;
    private Long userNo;
    private Long selected;
    private String createdSelectedTime;

}
