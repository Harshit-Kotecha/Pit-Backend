package com.help.pit.dao;

import com.help.pit.entity.Donation;

import java.util.List;

public interface CustomDonationRepository {
    List<Donation> updateImages(List<Donation> donations);
}
