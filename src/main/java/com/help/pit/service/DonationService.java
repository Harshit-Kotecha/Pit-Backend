package com.help.pit.service;

import com.help.pit.entity.Donation;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DonationService {
    List<Donation> findAll();

    Donation findById(Long id);

    Donation save(Donation donation);

    void deleteById(Long id);

    Object updateDonationStatus(@Param("status") String status, @Param("id") Long id);

    List<Donation> filterByName(String name);
}
