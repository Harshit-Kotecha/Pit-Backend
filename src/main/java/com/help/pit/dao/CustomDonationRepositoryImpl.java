package com.help.pit.dao;

import com.help.pit.entity.SuccessResponse;
import org.springframework.stereotype.Repository;

@Repository
public class CustomDonationRepositoryImpl implements CustomDonationRepository {
    @Override
    public SuccessResponse<String> updateDonationStatus(String status, Long id) {
        return new SuccessResponse();
    }
}
