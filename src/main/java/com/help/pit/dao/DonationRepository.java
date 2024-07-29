package com.help.pit.dao;

import com.help.pit.entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query(value = "SELECT d.id, d.name, d.age, d.address, d.category, d.expiry_time, " +
            "array_agg(i.url) as images " +
            "FROM donations d " +
            "LEFT JOIN images i ON d.id = i.donation_id " +
            "GROUP BY d.id", nativeQuery = true)
    List<Donation> getDonationsWithImages();
}
