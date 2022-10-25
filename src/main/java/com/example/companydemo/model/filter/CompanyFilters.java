package com.example.companydemo.model.filter;

import com.unicloud.model.filter.IFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder(toBuilder = true)
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyFilters implements IFilter {
    private String taxCode;
    private String name;
    private String nation;
    private String companyCode;
    private String shortName;
    private String address;
    private String scale;
    private String facebook;
    private String email;
    private String phoneNumber;
    private String website;
    private String legalType;
    private LocalDateTime establishDate;
    private String representative;
    private String businessType;
    private String logo;
    private Boolean active;
    private Boolean deleted;
    private String workingTime;
    private String introduce;
    private String keyword;
}

