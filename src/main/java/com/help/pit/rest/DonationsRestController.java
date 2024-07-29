package com.help.pit.rest;

import com.help.pit.dao.DonationStages;
import com.help.pit.entity.*;
import com.help.pit.service.DonationService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
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
    public BaseResponse<List<DonationWithImages>> findAll() {
        return new SuccessResponse<>(donationService.getDonationsWithImages());
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

    @PatchMapping("/donation/update/{id}")
    public Integer updateDonationStatus(@PathVariable(name = "id") Long id, @RequestParam(name = "status") DonationStages status) {
        Object a = donationService.updateDonationStatus(status, id);
        return 2;
    }

    @GetMapping("/donations/k")
    public List<Donation> filterByName(@RequestParam(name = "name", required = false) String name) {
        return donationService.filterByName(name);
    }
}
