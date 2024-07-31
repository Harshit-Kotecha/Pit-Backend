package com.help.pit.entity;

import java.util.List;

public interface DonationDTO {
    Long getId();

    String getName();

    String getAddress();

    Integer getAge();

    String getCategory();

    String getExpiryTime();

    String getStatus();

    List<String> getImages();
}
