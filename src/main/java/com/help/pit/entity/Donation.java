package com.help.pit.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.help.pit.dao.DonationStages;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import java.util.List;


@Entity
@Table(name = "donations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    @Min(18) @Max(120)
    private Integer age;

    @Column(name = "address")
    private String address;

    @Column(name = "expiry_time")
    @JsonProperty("expiry_time_in_hours")
    private Integer expiryTimeInHours;

    @Column(name = "category")
    private String category;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "donation_stages")
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private DonationStages status;

    @Column(name = "images")
    private List<String> images;
}
