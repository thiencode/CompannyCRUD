package com.example.companydemo.factory.interfaces;

import com.example.companydemo.model.companyModel.CompanyDetail;
import com.example.companydemo.model.companyModel.CompanyInfo;
import com.unicloud.factory.IDataFactory;

import java.util.UUID;

public interface ICompanyValidateFactory extends IDataFactory<UUID, CompanyInfo, CompanyDetail> {
}
