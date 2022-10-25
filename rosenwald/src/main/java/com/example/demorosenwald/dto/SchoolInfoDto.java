package com.example.demorosenwald.dto;

import com.example.demorosenwald.entity.SchoolFund;
import lombok.Data;

import javax.persistence.Column;

@Data
public class SchoolInfoDto {

    private String UID;

    private String State;

    private String County;

    private String schoolNames;

    private String Title;

    private String Description;

    private String acreage;

    private String teacherType;

    private String budgetYear;

    private String  totalCost;

    private String negroesContribution;

    private String whitesContribution;

    private String publicContribution;

    private String rosenwaldContribution;

    public SchoolFund toEntity() {
        SchoolFund schoolFund = new SchoolFund();
        return schoolFund;

//        schoolFund.setAlternateNames(schoolNames);
//        schoolFund.setAppl(Appl);
//        schoolFund.setCounty(County);
//        schoolFund.setSchoolNames(schoolNames);
//        schoolFund.setCreator(Creator);
//        schoolFund.setSchoolCardId(schoolPhotoId);
//        schoolFund.setFormat(Format);
//        schoolFund.setDescription(Description);
//        schoolFund.setPublisher(Publisher);
//        schoolFund.setTitle(Title);
//        schoolFund.setRights(Rights);
//        schoolFund.setOriginalDate(originalDate);
//        schoolFund.setUID(UID);
//        schoolFund.setSt
    }

}
