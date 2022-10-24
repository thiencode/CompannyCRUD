package com.example.companydemo.factory;

import com.example.companydemo.entity.CompanyEntity;
import com.example.companydemo.factory.interfaces.ICompanyFactory;
import com.example.companydemo.model.companyModel.CompanyDetail;
import com.example.companydemo.model.companyModel.CompanyInfo;
import com.example.companydemo.model.filter.CompanyFilters;
import com.example.companydemo.repository.CompanyRepository;
import com.unicloud.exception.InvalidException;
import com.unicloud.factory.BasePersistDataFactory;
import com.unicloud.model.filter.IFilter;
import com.unicloud.util.TimeUtil;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CompanyFactory extends BasePersistDataFactory<UUID, CompanyInfo, CompanyDetail, UUID, CompanyEntity> implements ICompanyFactory {
    private final CompanyRepository companyRepository;


    protected CompanyFactory(PagingAndSortingRepository<CompanyEntity, UUID> repository, CompanyRepository companyRepository) {
        super(repository);
        this.companyRepository = companyRepository;
    }

    @Override
    protected Class<CompanyDetail> getDetailClass() {
        return CompanyDetail.class;
    }

    @Override
    public CompanyEntity createConvertToEntity(CompanyDetail companyDetail) throws InvalidException {
        return CompanyEntity.builder()
                .name(companyDetail.getName())
                .address(companyDetail.getAddress())
                .email(companyDetail.getEmail())
                .taxCode(companyDetail.getTaxCode())
                .logo(companyDetail.getLogo())
                .companyCode(companyDetail.getCompanyCode())
                .shortName(companyDetail.getShortName())
                .scale(companyDetail.getScale())
                .facebook(companyDetail.getFacebook())
                .phoneNumber(companyDetail.getPhoneNumber())
                .website(companyDetail.getWebsite())
                .legalType(companyDetail.getLegalType())
                .establishDate(TimeUtil.toLocalDateTime(companyDetail.getEstablishDate()))
                .representative(companyDetail.getRepresentative())
                .businessType(companyDetail.getBusinessType())
                .nation(companyDetail.getNation())
                .workingTime(companyDetail.getWorkingTime())
                .active(companyDetail.isActive())
                .deleted(companyDetail.isDeleted())
                .introduce(companyDetail.getIntroduce())
                .keyword(companyDetail.getKeyword())
                .build();
    }

    @Override
    public void updateConvertToEntity(CompanyEntity companyEntity, CompanyDetail companyDetail) throws InvalidException {
        companyEntity.setAddress(companyDetail.getAddress());
        companyEntity.setEmail(companyDetail.getEmail());
        companyEntity.setTaxCode(companyDetail.getTaxCode());
        companyEntity.setLogo(companyDetail.getLogo());
        companyEntity.setCompanyCode(companyDetail.getCompanyCode());
        companyEntity.setShortName(companyDetail.getShortName());
        companyEntity.setScale(companyDetail.getScale());
        companyEntity.setFacebook(companyDetail.getFacebook());
        companyEntity.setPhoneNumber(companyDetail.getPhoneNumber());
        companyEntity.setWebsite(companyDetail.getWebsite());
        companyEntity.setLegalType(companyDetail.getLegalType());
        companyEntity.setEstablishDate(TimeUtil.toLocalDateTime(companyDetail.getEstablishDate()));
        companyEntity.setRepresentative(companyDetail.getRepresentative());
        companyEntity.setBusinessType(companyDetail.getBusinessType());
        companyEntity.setNation(companyDetail.getNation());
        companyEntity.setWorkingTime(companyDetail.getWorkingTime());
        companyEntity.setName(companyDetail.getName());
        companyEntity.setActive(companyDetail.isActive());
        companyEntity.setDeleted(companyDetail.isDeleted());
        companyEntity.setIntroduce(companyDetail.getIntroduce());
        companyEntity.setKeyword(companyDetail.getKeyword());
    }

    @Override
    public CompanyDetail convertToDetail(CompanyEntity companyEntity) throws InvalidException {
        return CompanyDetail.builder()
                .id(companyEntity.getId())
                .name(companyEntity.getName())
                .address(companyEntity.getAddress())
                .email(companyEntity.getEmail())
                .taxCode(companyEntity.getTaxCode())
                .logo(companyEntity.getLogo())
                .companyCode(companyEntity.getCompanyCode())
                .shortName(companyEntity.getShortName())
                .scale(companyEntity.getScale())
                .facebook(companyEntity.getFacebook())
                .phoneNumber(companyEntity.getPhoneNumber())
                .website(companyEntity.getWebsite())
                .legalType(companyEntity.getLegalType())
                .establishDate(TimeUtil.toTimeStamp(companyEntity.getEstablishDate()))
                .representative(companyEntity.getRepresentative())
                .businessType(companyEntity.getBusinessType())
                .nation(companyEntity.getNation())
                .workingTime(companyEntity.getWorkingTime())
                .active(companyEntity.isActive())
                .deleted(companyEntity.isDeleted())
                .introduce(companyEntity.getIntroduce())
                .keyword(companyEntity.getKeyword())
                .build();
    }

    @Override
    public CompanyInfo convertToInfo(CompanyEntity companyEntity) throws InvalidException {
        return CompanyInfo.builder()
                .id(companyEntity.getId())
                .name(companyEntity.getName())
                .address(companyEntity.getAddress())
                .email(companyEntity.getEmail())
                .taxCode(companyEntity.getTaxCode())
                .logo(companyEntity.getLogo())
                .build();
    }

    @Override
    protected <F extends IFilter> Iterable<CompanyEntity> listQuery(F ignoreFilter) throws InvalidException {
        if (ignoreFilter instanceof CompanyFilters companyFilters)
            return companyRepository.getInfoListByFilter(
                    companyFilters.getName(), companyFilters.getTaxCode(), companyFilters.getNation(), companyFilters.getShortName(),
                    companyFilters.getAddress(), companyFilters.getScale(), companyFilters.getFacebook(),
                    companyFilters.getEmail(), companyFilters.getPhoneNumber(),
                    companyFilters.getWebsite(), companyFilters.getLegalType(),
                    companyFilters.getEstablishDate(), companyFilters.getRepresentative(),
                    companyFilters.getLogo(), companyFilters.getActive(), companyFilters.getDeleted(),
                    companyFilters.getWorkingTime(), companyFilters.getBusinessType(),
                    companyFilters.getIntroduce(), companyFilters.getKeyword()
            );
        return super.listQuery();
    }
}