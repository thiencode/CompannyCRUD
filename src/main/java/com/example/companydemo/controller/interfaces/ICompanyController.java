package com.example.companydemo.controller.interfaces;

import com.example.companydemo.model.companyModel.CompanyDetail;
import com.example.companydemo.model.companyModel.CompanyInfo;
import com.example.companydemo.model.filter.CompanyFilters;
import com.unicloud.controller.*;

import java.util.UUID;

public interface ICompanyController extends
        ICreateModelController<UUID, CompanyDetail>,
        IUpdateIdModelController<UUID, CompanyDetail>,
        IDeleteModelByIdController<UUID>,
        IGetDetailByIdController<UUID, CompanyDetail>,
        IGetInfoListWithFilterController<UUID, CompanyInfo, CompanyFilters> {
}
