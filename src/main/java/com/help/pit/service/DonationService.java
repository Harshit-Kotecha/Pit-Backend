package com.help.pit.service;

import com.help.pit.entity.Donation;

import java.util.List;

public interface DonationService {
    List<Donation> findAll();

    Donation findById(Long id);

    Donation save(Donation donation);

    void deleteById(Long id);

    List<Donation> getDonationsWithImages();

}
