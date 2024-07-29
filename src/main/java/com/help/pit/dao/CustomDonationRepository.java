package com.help.pit.dao;

import com.help.pit.entity.SuccessResponse;
import org.springframework.data.repository.query.Param;

public interface CustomDonationRepository {
    SuccessResponse<String> updateDonationStatus(@Param("status") String status, @Param("id") Long id);
}
