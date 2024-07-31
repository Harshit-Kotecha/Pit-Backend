package com.help.pit.rest;

import com.help.pit.entity.*;
import com.help.pit.service.DonationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@AllArgsConstructor
public class DonationsRestController {
    private DonationService donationService;

    @GetMapping("/donations")
    public BaseResponse<List<Donation>> findAll(@RequestParam(name = "name", required = false) String name) {
        if(name != null) {
            return new SuccessResponse<>(donationService.filterByName(name));
        }
        return new SuccessResponse<>(donationService.findAll());
    }

    @GetMapping("/donations/{id}")
    public BaseResponse<Donation> findById(@PathVariable(name = "id") Long id) {
        return new SuccessResponse<>(donationService.findById(id));

    }

    @PostMapping("/donations")
    public BaseResponse<Donation> add(@RequestBody Donation donation) {
        if (donation == null) {
            throw new RuntimeException("Null data received");
        }
        final Donation result = donationService.save(donation);
        return new SuccessResponse<>(result);

    }

    @PatchMapping("/donation/update/{id}")
    public Integer updateDonationStatus(@PathVariable(name = "id") Long id, @RequestParam(name = "status") String status) {
        Object a = donationService.updateDonationStatus(status, id);
        return 2;
    }
}
