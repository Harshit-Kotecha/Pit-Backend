package com.help.pit.dao;

import com.help.pit.entity.Donation;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomDonationRepositoryImpl implements CustomDonationRepository {
    private EntityManager entityManager;

    @Override
    public List<Donation> updateImages(List<Donation> donations) {

    }
}
