package com.help.pit.rest;

import com.help.pit.entity.Donation;
import com.help.pit.service.DonationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
@AllArgsConstructor
public class DonationsRestController {
    private DonationService donationService;

    @GetMapping("/donations")
    public ResponseEntity<List<Donation>> findAll() {
        return new ResponseEntity<>(donationService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/donations/{id}")
    public ResponseEntity<Donation> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(donationService.findById(id));
    }
}
