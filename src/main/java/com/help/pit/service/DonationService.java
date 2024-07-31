package com.help.pit.service;

import com.help.pit.dao.DonationStages;
import com.help.pit.entity.Donation;
import com.help.pit.entity.DonationDTO;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DonationService {
    List<Donation> findAll();

    Donation findById(Long id);

    Donation save(Donation donation);

    void deleteById(Long id);

    List<DonationDTO> getDonationsWithImages();


    Object updateDonationStatus(@Param("status") DonationStages status, @Param("id") Long id);

    List<Donation> filterByName(String name);

    DonationDTO getDonationById(@Param("id") Long id);
}
