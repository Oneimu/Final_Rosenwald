package com.example.demorosenwald.dto;

import com.example.demorosenwald.entity.SchoolFund;
import lombok.Data;

import javax.persistence.Column;

@Data
public class SchoolFundDto {

    private String UID;

    private String State;

    private String County;

    private String schoolNames;

    private String alternateNames;

    private String Appl;

    private String originalDate;

    private String Title;

    private String Subject;

    private String Description;

    private String Creator;

    private String Source;

    private String Publisher;

    private String Rights;

    private String Format;

    private String schoolPhotoId;

    private String itemNumber;

    private String acreage;

    private String teacherType;

    private String budgetYear;

    private String  totalCost;

    private String negroesContribution;

    private String whitesContribution;

    private String publicContribution;

    private String rosenwaldContribution;

    public SchoolFund toEntity(){
        SchoolFund schoolFund = new SchoolFund();

        schoolFund.setAlternateNames(schoolNames);
        schoolFund.setAppl(Appl);
        schoolFund.setCounty(County);
        schoolFund.setSchoolNames(schoolNames);
        schoolFund.setCreator(Creator);
        schoolFund.setSchoolCardId(schoolPhotoId);
        schoolFund.setFormat(Format);
        schoolFund.setDescription(Description);
        schoolFund.setPublisher(Publisher);
        schoolFund.setTitle(Title);
        schoolFund.setRights(Rights);
        schoolFund.setOriginalDate(originalDate);
        schoolFund.setUID(UID);
        schoolFund.setState(State);
        schoolFund.setSource(Source);
        schoolFund.setSubject(Subject);
        schoolFund.setAcreage(acreage);
        schoolFund.setBudgetYear(budgetYear);
        schoolFund.setItemNumber(itemNumber);
        schoolFund.setNegroesContribution(negroesContribution);
        schoolFund.setPublicContribution(publicContribution);
        schoolFund.setWhitesContribution(whitesContribution);
        schoolFund.setTeacherType(teacherType);
        schoolFund.setTotalCost(totalCost);
        schoolFund.setRosenwaldContribution(rosenwaldContribution);

        return schoolFund;

    }
}
