package com.help.pit.rest;

import com.help.pit.entity.BaseResponse;
import com.help.pit.entity.Donation;
import com.help.pit.entity.FailureResponse;
import com.help.pit.entity.SuccessResponse;
import com.help.pit.service.DonationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@AllArgsConstructor
public class DonationsRestController {
    private DonationService donationService;

    @GetMapping("/donations")
    public BaseResponse<List<Donation>> findAll() {
        return new SuccessResponse<>(donationService.findAll());
    }

    @GetMapping("/donations/{id}")
    public BaseResponse<Donation> findById(@PathVariable(name = "id") Long id) {
        return new SuccessResponse<>(donationService.findById(id));

    }

    @PostMapping("/donations")
    public BaseResponse<Donation> add(@RequestBody Donation donation) {
        if(donation == null) {
            throw new RuntimeException("Null data received");
        }
        final Donation result = donationService.save(donation);
        return new SuccessResponse<>(result);

    }
}
