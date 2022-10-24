package com.example.companydemo.controller;

import com.example.companydemo.controller.interfaces.ICompanyController;
import com.example.companydemo.model.companyModel.CompanyDetail;
import com.example.companydemo.model.companyModel.CompanyInfo;
import com.example.companydemo.model.filter.CompanyFilters;
import com.unicloud.controller.BaseController;
import com.unicloud.factory.IDataFactory;
import com.unicloud.factory.IResponseFactory;
import com.unicloud.model.factory.request.FactoryCreateRequest;
import com.unicloud.model.factory.response.BaseResponse;
import com.unicloud.model.factory.response.FactoryDeleteResponse;
import com.unicloud.model.factory.response.FactoryGetResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/company")
@Tag(name = "Company Controller", description = "Quản lý thao tác công ty")
public class CompanyController extends BaseController<UUID, CompanyInfo, CompanyDetail> implements ICompanyController {
    protected CompanyController(@Qualifier("companyValidateFactory") IDataFactory<UUID, CompanyInfo, CompanyDetail> iDataFactory, IResponseFactory iResponseFactory) {
        super(iDataFactory, iResponseFactory);
    }

    @Override
    @Operation(summary = "Tạo công ty mới vào danh sách")
    public ResponseEntity<BaseResponse<CompanyDetail>> createModel(@Valid FactoryCreateRequest<UUID, CompanyDetail> factoryCreateRequest) {
        return super.factoryCreateModel(factoryCreateRequest);
    }

    @Override
    @Operation(summary = "Xóa công ty theo id")
    public ResponseEntity<BaseResponse<FactoryDeleteResponse>> deleteModelById(UUID id) {
        return super.factoryDeleteWithFilter(id, null);
    }

    @Override
    @Operation(summary = "Hiển thị chi tiết thông tin công ty theo id")
    public ResponseEntity<BaseResponse<FactoryGetResponse<UUID, CompanyDetail>>> getDetailById(UUID id) {
        return super.factoryGetDetailById(id);
    }

    @Override
    @Operation(summary = "Cập nhật thông tin công ty")
    public ResponseEntity<BaseResponse<CompanyDetail>> updateModel(UUID id, @Valid CompanyDetail companyDetail) {
        return super.factoryUpdateModel(id, companyDetail);
    }

    @Override
    @Operation(summary = "Hiển thị danh sách công ty theo filter")
    public ResponseEntity<BaseResponse<List<CompanyInfo>>> getInfoListWithFilter(@Valid CompanyFilters companyFilters) {
        return super.factoryGetInfoListWithFilter(companyFilters);
    }
}
