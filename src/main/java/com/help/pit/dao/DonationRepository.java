package com.help.pit.dao;

import com.help.pit.entity.Donation;
import com.help.pit.entity.DonationWithImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query(value = "SELECT d.id id, name, age, address, category, expiry_time expiryTime, status, " +
            "array_agg(url) as images " +
            "FROM donations d " +
            "LEFT JOIN images i ON d.id = i.donation_id " +
            "GROUP BY d.id", nativeQuery = true)
    List<DonationWithImages> getDonationsWithImages();

    @Transactional
    @Modifying
    @Query("UPDATE Donation SET status = :status WHERE id = :id")
    Object updateDonationStatus(@Param("status") DonationStages status, @Param("id") Long id);

    @Query("FROM Donation WHERE name LIKE %:name%")
    List<Donation> findByName(@Param("name") String name);
}