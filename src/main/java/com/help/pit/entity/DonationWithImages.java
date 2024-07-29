package com.help.pit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class DonationWithImages  {
    private Long id;

    private String name;

    private Integer age;

    private String address;

    private Integer expiryTime;

    private String category;

    private String status;

    private List<String> images;
//
//    public DonationWithImages(Long id, String name, Integer age, String address, Integer expiryTime, String category, String status, List<String> images) {
//        super(id, name, age, address, expiryTime, category, status);
//        this.images = images;
//    }
}
