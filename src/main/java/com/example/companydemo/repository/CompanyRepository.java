package com.example.companydemo.repository;

import com.example.companydemo.entity.CompanyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface CompanyRepository extends MongoRepository<CompanyEntity, UUID> {
    /*@Query(
            "{" +
                    "   $and: [" +
                    "       { $or: [ {$expr: {$eq: [':#{#taxCode}', 'null']} }, {'taxCode': {$eq: :#{#taxCode}} } ] }" +
                    "   ]" +
                    "}"
    )
    List<CompanyEntity> getInfoListByTaxCode(String taxCode);*/

    @Query(
            "{" +
                    "   $and: [" +
                    "       { $or: [ {$expr: {$eq: [':#{#taxCode}', 'null']} }, {'taxCode': {$eq: :#{#taxCode}} } ] }," +
                    "       { $or: [ {$expr: {$eq: [':#{#name}', 'null']} }, {'name': {$regex: ':#{#name}', $options: 'i'} } ] }," +
                    "       { $or: [ {$expr: {$eq: [':#{#nation}', 'null']} }, {'nation': {$regex: ':#{#nation}', $options: 'i'} } ] }," +
                    "       { $or: [ {$expr: {$eq: [':#{#shortName}', 'null']} }, {'shortName': {$eq: ':#{#shortName}'} } ] }," +
                    "       { $or: [ {$expr: {$eq: [':#{#address}', 'null']} }, {'address': {$regex: ':#{#address}', $options: 'i'} } ] }," +
                    "       { $or: [ {$expr: {$eq: [':#{#email}', 'null']} }, {'email': {$eq: ':#{#email}'} } ] }," +
                    "       { $or: [ {$expr: {$eq: [':#{#phoneNumber}', 'null']} }, {'phoneNumber': {$eq: ':#{#phoneNumber}'} } ] }," +
                    "       { $or: [ {$expr: {$eq: [':#{#website}', 'null']} }, {'website': {$eq: ':#{#website}'} } ] }," +
                    "       { $or: [ {$expr: {$eq: [':#{#legalType}', 'null']} }, {'legalType': {$eq: ':#{#legalType}'} } ] }," +
                    "       { $or: [ {$expr: {$eq: [':#{#establishDate}', 'null']} }, {'establishDate': {$eq: ':#{#establishDate}'} } ] }," +
                    "       { $or: [ {$expr: {$eq: [':#{#representative}', 'null']} }, {'representative': {$eq: ':#{#representative}'} } ] }," +
                    "       { $or: [ {$expr: {$eq: [':#{#active}', 'null']} }, {'active': :#{#active} } ] }," +
                    "       { $or: [ {$expr: {$eq: [':#{#deleted}', 'null']} }, {'deleted': :#{#deleted} } ] }," +
                    "       { $or: [ {$expr: {$eq: [':#{#businessType}', 'null']} }, { 'businessType': { $in: :#{#businessType} } } ] }" +
                    "       { $or: [ {$expr: {$eq: [':#{#introduce}', 'null']} }, { 'introduce': { $in: :#{#introduce} } } ] }," +
                    "       { $or: [ {$expr: {$eq: [':#{#keyword}', 'null']} }, { 'keyword': { $in: :#{#keyword} } } ] }" +
                    "       ]" +
                    "}"
    )
    List<CompanyEntity> getInfoListByFilter(
            String name, String taxCode, String nation, String shortName,
            String address, String scale,
            String facebook, String email, String phoneNumber, String website,
            String legalType, LocalDateTime establishDate, String representative,
            String logo, Boolean active, Boolean deleted,
            String workingTime, String[] businessType, String[] introduce,
            String[] keyword
    );

    @Override
    void deleteAll(Iterable<? extends CompanyEntity> entities);
}