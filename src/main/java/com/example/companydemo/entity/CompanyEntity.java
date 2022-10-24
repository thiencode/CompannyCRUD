package com.example.companydemo.entity;

import com.example.companydemo.entity.base.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(value = "company")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class CompanyEntity extends BaseEntity {

    private String companyCode;
    private String name;
    private String shortName;
    private String address;
    private String scale;
    private String taxCode;
    private String facebook;
    private String email;
    private String phoneNumber;
    private String website;
    private String legalType;
    private LocalDateTime establishDate;
    private String representative;
    private List<String> businessType;
    private String logo;
    private boolean active;
    private boolean deleted;
    private String nation;
    private String workingTime;
    private List<String> introduce;
    private List<String> keyword;
}