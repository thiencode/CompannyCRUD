package com.example.companydemo.model.filter;

import com.unicloud.model.filter.IFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder(toBuilder = true)
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyFilter implements IFilter {
    private String taxCode;
}
