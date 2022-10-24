package com.example.companydemo.factory;

import com.example.companydemo.factory.interfaces.ICompanyFactory;
import com.example.companydemo.factory.interfaces.ICompanyValidateFactory;
import com.example.companydemo.model.companyModel.CompanyDetail;
import com.example.companydemo.model.companyModel.CompanyInfo;
import com.unicloud.exception.ErrorCode;
import com.unicloud.exception.InvalidException;
import com.unicloud.factory.BaseDataFactory;
import com.unicloud.model.factory.response.BasePagingResponse;
import com.unicloud.model.filter.IFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
public class CompanyValidateFactory extends BaseDataFactory<UUID, CompanyInfo, CompanyDetail> implements ICompanyValidateFactory {
    private final ICompanyFactory iCompanyFactory;

    public CompanyValidateFactory(ICompanyFactory iCompanyFactory) {
        this.iCompanyFactory = iCompanyFactory;
    }

    @Override
    protected CompanyDetail aroundCreate(CompanyDetail companyDetail) throws InvalidException {
        log.info("Create by Company validate Factory");
        if (!companyDetail.getNation().equalsIgnoreCase("Việt Nam"))
            throw new InvalidException(ErrorCode.NOT_FOUND);
        else
            return iCompanyFactory.createModel(companyDetail);
    }

    @Override
    protected CompanyDetail aroundUpdate(UUID uuid, CompanyDetail companyDetail) throws InvalidException {
        return iCompanyFactory.updateModel(uuid, companyDetail);
    }

    @Override
    protected <F extends IFilter> void aroundDelete(UUID uuid, F f) throws InvalidException {
        iCompanyFactory.deleteModel(uuid, f);
    }

    @Override
    protected <F extends IFilter> CompanyDetail aroundGetDetail(UUID uuid, F f) throws InvalidException {
        return iCompanyFactory.getDetailModel(uuid, f);
    }

    @Override
    protected <F extends IFilter> List<CompanyInfo> aroundGetList(F f) throws InvalidException {
        return null;
    }


    @Override
    protected List<CompanyInfo> aroundGetList() throws InvalidException {
        return iCompanyFactory.getInfoList();
    }

    @Override
    protected <F extends IFilter> BasePagingResponse<CompanyInfo> aroundGetPage(F f, Integer integer, Integer integer1) throws InvalidException {
        return iCompanyFactory.getInfoPage(f, integer, integer1);
    }

    @Override
    protected Class<CompanyDetail> getDetailClass() {
        return CompanyDetail.class;
    }

    @Override
    public <F extends IFilter> boolean existByFilter(UUID uuid, F f) throws InvalidException {
        log.info("----- Company Validate Factory -----");
        return iCompanyFactory.existByFilter(uuid, f);
    }

    @Override
    public boolean existByDetail(CompanyDetail companyDetail) throws InvalidException {
        log.info("----- Company Validate Factory -----");
        return iCompanyFactory.existByDetail(companyDetail);
    }


    @Override
    public <F extends IFilter> List<CompanyInfo> getInfoList(F filter) throws InvalidException {
        return iCompanyFactory.getInfoList(filter);
    }
}
