package com.example.companydemo.model.companyModel;

import com.example.companydemo.model.base.BaseModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuperBuilder(toBuilder = true)
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CompanyInfo extends BaseModel {
    @NotNull
    @Schema(description = "Tên công ty")
    @Size(max = 200)
    private String name;

    @NotNull
    @Schema(description = "Địa chỉ công ty")
    @Size(max = 200)
    private String address;

    @NotNull
    @Schema(description = "Địa chỉ email")
    @Size(max = 200)
    private String email;

    @NotNull
    @Schema(description = "Mã số thuế công ty")
    @Size(max = 200)
    private String taxCode;

    @NotNull
    @Schema(description = "Đường dẫn hình ảnh lô gô công ty")
    @Size(max = 200)
    private String logo;
}
