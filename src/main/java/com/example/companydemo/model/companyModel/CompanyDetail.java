package com.example.companydemo.model.companyModel;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.List;

@SuperBuilder(toBuilder = true)
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyDetail extends CompanyInfo {

    @NotNull
    @Schema(description = "Mã xác minh thông tin doanh nghiệp")
    @Size(max = 200)
    private String companyCode;

    @NotNull
    @Schema(description = "Tên viết tắt của công ty")
    @Size(max = 200)
    private String shortName;

    @Null
    @Schema(description = "Quy mô công ty")
    @Size(max = 200)
    private String scale;

    @NotNull
    @Schema(description = "Địa chỉ facebook công ty")
    @Size(max = 200)
    private String facebook;

    @NotNull
    @Schema(description = "Số điện thoại công ty")
    @Size(max = 200)
    private String phoneNumber;

    @Schema(description = "Địa chỉ trang web công ty")
    @Size(max = 200)
    private String website;

    @NotNull
    @Schema(description = "Loại hình pháp lý công ty")
    @Size(max = 200)
    private String legalType;

    @NotNull
    @Schema(description = "Ngày thành lập công ty")
    @Size(max = 200)
    private long establishDate;

    @NotNull
    @Schema(description = "Tên người đại diện công ty")
    @Size(max = 200)
    private String representative;

    @NotNull
    @Schema(description = "Loại hình doanh nghiệp")
    @Size(max = 200)
    private List<String> businessType;

    @NotNull
    @Schema(description = "Tên quốc gia")
    @Size(max = 200)
    private String nation;

    @NotNull
    @Schema(description = "Thời gian làm việc của công ty")
    @Size(max = 200)
    private String workingTime;

    @NotNull
    @Schema(description = "Kiểm tra công ty còn hiệu lực không")
    @Size(max = 200)
    private boolean active;

    @NotNull
    @Schema(description = "Kiểm tra công ty có bị xóa chưa")
    @Size(max = 200)
    private boolean deleted;

    @NotNull
    @Schema(description = "Kiểm tra công ty có bị xóa chưa")
    @Size(max = 200)
    private List<String> introduce;

    @NotNull
    @Schema(description = "Kiểm tra công ty có bị xóa chưa")
    @Size(max = 200)
    private List<String> keyword;
}